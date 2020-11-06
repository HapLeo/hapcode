package top.hapleow.hapcodeweb.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodecore.common.Cache;
import top.hapleow.hapcodecore.common.Const;
import top.hapleow.hapcodecore.generator.IGenerator;
import top.hapleow.hapcodecore.model.FieldModel;
import top.hapleow.hapcodecore.model.TableModel;
import top.hapleow.hapcodeweb.context.APIMdTemplateContext;
import top.hapleow.hapcodeweb.dto.CodingApiDto;
import top.hapleow.hapcodeweb.service.ICodeApiService;
import top.hapleow.hapcodeweb.service.ITableInfoService;

import java.io.*;
import java.util.*;

/**
 * 生成API的服务
 *
 * @author wuyulin
 * @date 2020/11/5
 */
@Service
public class CodeApiServiceImpl implements ICodeApiService {


    @Autowired
    private ITableInfoService tableInfoService;

    @Autowired
    private IGenerator generator;


    @Override
    public void codingApi(CodingApiDto codingApiDto) {

        if (codingApiDto.getTableNames() == null) {
            throw new IllegalArgumentException("表名列表不能为空");
        }
        if (codingApiDto.getDesc() == null) {
            throw new IllegalArgumentException("接口描述不能为空");
        }

        if (codingApiDto.getDestPath() == null) {
            String filePath = null;
            try {
                filePath = File.createTempFile(codingApiDto.getTableNames().get(0), ".md").getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
            }
            codingApiDto.setDestPath(filePath);
        }

        // 将涉及到的表的字段列表缓存起来

        for (String tableName : codingApiDto.getTableNames()) {

            TableModel tableModel = tableInfoService.getTableModel(tableName);
            if (tableModel != null) {
                for (FieldModel field : tableModel.getFields()) {
                    Cache.FIELD_MODEL_MAP_CACHE.put(field.getPropertyName(), field);
                }
            }
        }

        // 将DTO注入到上下文
        APIMdTemplateContext templateContext = new APIMdTemplateContext();
        templateContext.setDto(codingApiDto);

        // 处理文件名和地址
        String destPath = codingApiDto.getDestPath();
        String fileName = destPath.substring(destPath.lastIndexOf(File.separator) + 1);
        String filePath = destPath.substring(0, destPath.lastIndexOf(File.separator));
        templateContext.setFileName(fileName);
        templateContext.setFilePath(filePath);

        // 获取DTO中的内容
        String dtoAbPath = codingApiDto.getDtoAbPath();
        templateContext.setDtoFieldList(getDtoFieldList(dtoAbPath));

        // 获取接口的返回值
        templateContext.setResponseStr(codingApiDto.getResponseStr());

        Map<String, FieldModel> fieldsMap = new HashMap<>();
        fieldsMap = parseResponseStr(codingApiDto.getResponseStr(), fieldsMap);

        templateContext.setResponseList(fieldsMap.values());

        generator.writeToFile(Const.APITemplateKey, templateContext);

    }

    /**
     * 解析接口返回字符串
     *
     * @param responseStr
     * @return
     */
    private Map<String, FieldModel> parseResponseStr(String responseStr, Map<String, FieldModel> fieldModels) {
        if (responseStr == null || "".equals(responseStr)) {
            return fieldModels;
        }
        Object parent = JSON.parse(responseStr);

        if (parent instanceof JSONObject) {
            JSONObject jsonObject = JSON.parseObject(responseStr);
            for (String key : jsonObject.keySet()) {

                Object value = jsonObject.get(key);
                if (value != null && !(value instanceof JSONObject) && !(value instanceof JSONArray)) {

                    // 检查免识别字段
                    if (Cache.FIELD_EXCLUDE_INPUT_SET.contains(key)){
                        continue;
                    }
                    FieldModel existField = fieldModels.get(key);
                    if (existField == null) {
                        FieldModel fieldModel = new FieldModel();
                        fieldModel.setPropertyName(key);
                        FieldModel cacheField = Cache.FIELD_MODEL_MAP_CACHE.get(key);
                        if (cacheField != null) {
                            fieldModel.setComment(cacheField.getComment());
                            fieldModel.setJavaType(cacheField.getJavaType());
                        }
                        fieldModels.put(key, fieldModel);
                    }
                } else {
                    parseResponseStr(JSON.toJSONString(value), fieldModels);
                }

            }
        } else if (parent instanceof JSONArray) {
            JSONArray jsonArray = JSONArray.parseArray(responseStr);
            jsonArray.forEach(json -> {
                parseResponseStr(JSON.toJSONString(json), fieldModels);
            });
        }
        return fieldModels;
    }


    private List<Map<String, String>> getDtoFieldList(String dtoAbPath) {

        List<Map<String, String>> fieldList = new ArrayList<>();

        if (dtoAbPath == null || "".equals(dtoAbPath)) {
            return fieldList;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dtoAbPath));
            Map<String, String> currentField = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if ("".equals(line)) {
                    continue;
                }
                int index;
                if ((index = line.indexOf("@desc")) != -1) {
                    currentField = new HashMap<>();
                    fieldList.add(currentField);
                    currentField.put("comment", line.substring(index + 5).trim());
                } else if ((index = line.indexOf("private")) != -1) {

                    if (currentField == null) continue;

                    List<String> list = Arrays.asList(line.substring(index).trim().split(" "));
                    list.removeIf(""::equals);
                    Object[] lineItems = list.toArray();
                    currentField.put("javaType", (String) lineItems[1]);
                    currentField.put("propertyName", ((String) lineItems[2]).replace(";", ""));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fieldList;
    }

}
