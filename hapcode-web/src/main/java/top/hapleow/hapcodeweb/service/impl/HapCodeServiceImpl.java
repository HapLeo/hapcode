package top.hapleow.hapcodeweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodecore.common.Cache;
import top.hapleow.hapcodecore.common.Const;
import top.hapleow.hapcodecore.common.FileUtil;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.factory.TemplateContextFactory;
import top.hapleow.hapcodecore.generator.IGenerator;
import top.hapleow.hapcodecore.model.FieldModel;
import top.hapleow.hapcodecore.model.TableField;
import top.hapleow.hapcodecore.model.TableInfo;
import top.hapleow.hapcodecore.model.TableModel;
import top.hapleow.hapcodeweb.context.APIMdTemplateContext;
import top.hapleow.hapcodeweb.dto.CodingApiDto;
import top.hapleow.hapcodeweb.dto.CodingDto;
import top.hapleow.hapcodeweb.service.IHapCodeService;
import top.hapleow.hapcodeweb.service.ITableInfoService;

import java.io.File;
import java.io.IOException;
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

        if (codingApiDto.getTableNames() == null){
            throw new IllegalArgumentException("表名列表不能为空");
        }

        if (codingApiDto.getDestPath() == null){
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

        String destPath = codingApiDto.getDestPath();
        String fileName = destPath.substring(destPath.lastIndexOf(File.separator)+1);
        String filePath = destPath.substring(0, destPath.lastIndexOf(File.separator));
        APIMdTemplateContext templateContext = new APIMdTemplateContext();
        templateContext.setFileName(fileName);
        templateContext.setFilePath(filePath);
        doCodingApi(Const.APITemplateKey, templateContext);

    }

    private void doCodingApi(String templateName, APIMdTemplateContext templateContext) {

        // 生成表结构字段对照表
        generator.writeToFile(templateName, templateContext);

    }
}
