package top.hapleow.hapcodeweb.context;

import lombok.Data;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.config.PackageConfig;
import top.hapleow.hapcodecore.context.BasicTemplateContext;
import top.hapleow.hapcodecore.model.TableModel;

/**
 * DAO模板模型
 * 用于向模板传输数据
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class PageAddHtmlTemplateContext extends BasicTemplateContext {


    public PageAddHtmlTemplateContext(TableModel table, String tablePrefix, ApplicationConfig applicationConfig) {

        super(table, tablePrefix, applicationConfig);

        PackageConfig packageConfig = applicationConfig.getPackageConfig();
        this.setFileName(super.getBizEnName() + "_add.html");
        this.setFilePath(packageConfig.getModulePath() + packageConfig.getHtmlPath() + packageConfig.getBizModulePath() + super.getBizEnName() + "/");
    }

}
