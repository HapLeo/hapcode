package top.hapleow.hapcodecore.generator;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import top.hapleow.hapcodecore.common.Const;
import top.hapleow.hapcodecore.common.FileUtil;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.context.BasicTemplateContext;
import top.hapleow.hapcodecore.factory.TemplateContextFactory;
import top.hapleow.hapcodecore.model.TableModel;

import java.io.IOException;

/**
 * Beetl生成器
 *
 * @author wuyulin
 * @date 2020/9/15
 */
public class BeetlGenerator implements IGenerator {


    /**
     * 执行生成过程
     *
     * @param templateName
     * @param tableModel
     * @param applicationConfig
     */
    public void execute(String templateName, TableModel tableModel, ApplicationConfig applicationConfig) {

        BasicTemplateContext templateContext = TemplateContextFactory.getTemplateContext(templateName, tableModel, "lzc_", applicationConfig);

        //初始化代码
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();

        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            throw new RuntimeException("Beetl配置不存在");
        }
        //cfg.setHtmlTagFlag("!!!");
        cfg.setHtmlTagSupport(false);
        cfg.setPlaceholderStart("@{");
        cfg.setPlaceholderEnd("}");
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);

        //获取模板
        Template t = gt.getTemplate(Const.tempatePath + templateName);
        t.binding("context", templateContext);
        //gt.registerFunction("tool.currentTime", (objects, context) -> Tool.currentTime());


        //渲染结果
        String content = t.render();
        String fileName = templateContext.getFileName();
        String filePath = templateContext.getFilePath();

        FileUtil.createFile(content, fileName, filePath);
    }
}
