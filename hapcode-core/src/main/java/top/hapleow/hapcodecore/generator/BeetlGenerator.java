package top.hapleow.hapcodecore.generator;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import top.hapleow.hapcodecore.common.Const;
import top.hapleow.hapcodecore.common.Tool;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.model.ModelTemplateContext;
import top.hapleow.hapcodecore.model.TableModel;

import java.io.IOException;

/**
 * Beetl生成器
 *
 * @author wuyulin
 * @date 2020/9/15
 */
public class BeetlGenerator implements IGenerator {


    public void execute(String templateName, TableModel tableModel, ApplicationConfig applicationConfig) {

        ModelTemplateContext templateContext = new ModelTemplateContext(tableModel, "lzc_", applicationConfig.getPackageConfig().getPackageName());

        //初始化代码
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();

        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            throw new RuntimeException("Beetl配置不存在");
        }

        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);

        //获取模板
        Template t = gt.getTemplate(Const.tempatePath + templateName);
        t.binding("context", templateContext);
        gt.registerFunction("tool.currentTime", (objects, context) -> Tool.currentTime());

        //渲染结果
        String str = t.render();
        System.out.println(str);
    }

}
