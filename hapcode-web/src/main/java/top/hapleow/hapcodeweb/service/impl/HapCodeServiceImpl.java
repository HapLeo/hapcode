package top.hapleow.hapcodeweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodecore.common.Cache;
import top.hapleow.hapcodecore.common.Const;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.factory.TemplateContextFactory;
import top.hapleow.hapcodecore.generator.IGenerator;
import top.hapleow.hapcodecore.model.FieldModel;
import top.hapleow.hapcodecore.model.TableModel;
import top.hapleow.hapcodeweb.context.APIMdTemplateContext;
import top.hapleow.hapcodeweb.dto.CodingApiDto;
import top.hapleow.hapcodeweb.dto.CodingDto;
import top.hapleow.hapcodeweb.service.IHapCodeService;
import top.hapleow.hapcodeweb.service.ITableInfoService;

import java.io.*;
import java.util.*;

/**
 * 代码生成服务实现类
 *
 * @author wuyulin
 * @date 2020/9/16
 */
@Service
public class HapCodeServiceImpl implements IHapCodeService {

    @Autowired
    private ITableInfoService tableInfoService;

    @Autowired
    private IGenerator generator;


    @Override
    public void coding(CodingDto codingDto) {

        String bizModuleName = codingDto.getBizModuleName();
        String tableName = codingDto.getTableName();
        String templateKey = codingDto.getTemplateKey();

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setAuthor(codingDto.getAuthor());
        applicationConfig.getPackageConfig().setBizModuleName(bizModuleName);

        if (tableName == null || "".equals(tableName)) {
            throw new NullPointerException("表名为空");
        }

        if (templateKey == null || "".equals(templateKey)) {
            throw new NullPointerException("模板名称为空");
        }

        TableModel tableModel = tableInfoService.getTableModel(tableName);

        generator.execute(templateKey, tableModel, applicationConfig);
    }

    @Override
    public void codingAll(CodingDto codingDto) {

        TemplateContextFactory.autoRegistTemplate();
        Set<String> keySet = TemplateContextFactory.templateMap.keySet();
        for (String s : keySet) {
            codingDto.setTemplateKey(s);
            coding(codingDto);
        }
    }

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


        generator.writeToFile(Const.APITemplateKey, templateContext);

    }

    private List<Map<String, String>> getDtoFieldList(String dtoAbPath) {

        List<Map<String, String>> fieldList = new ArrayList<>();
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
                    currentField.put("propertyName", ((String) lineItems[2]).replace(";",""));
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
