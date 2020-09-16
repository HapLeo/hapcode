package top.hapleow.hapcodeweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.factory.TemplateContextFactory;
import top.hapleow.hapcodecore.generator.IGenerator;
import top.hapleow.hapcodecore.model.TableModel;
import top.hapleow.hapcodeweb.service.IHapCodeService;
import top.hapleow.hapcodeweb.service.ITableInfoService;

import java.util.Iterator;
import java.util.Set;

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
    public void coding(String tableName, String templateKey) {

        ApplicationConfig applicationConfig = new ApplicationConfig();

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
    public void codingAll(String tableName) {
        TemplateContextFactory.autoRegistTemplate();
        Set<String> keySet = TemplateContextFactory.templateMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            coding(tableName, iterator.next());
        }
    }
}
