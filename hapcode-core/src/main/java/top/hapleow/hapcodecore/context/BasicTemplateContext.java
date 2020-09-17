package top.hapleow.hapcodecore.context;

import lombok.Data;
import top.hapleow.hapcodecore.common.StringUtil;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.config.PackageConfig;
import top.hapleow.hapcodecore.model.TableModel;

/**
 * 基础模板模型
 * 用于向模板传输数据
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class BasicTemplateContext {

    private String author;

    private String bizChName;

    private String bizEnName;

    private String bizEnBigName;

    private String tablePrefix;

    private TableModel table;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     *
     */
    private String packageName;

    /**
     * 模块路径（业务模块，例如order）
     */
    private String bizModulePath;

    /**
     * model类的全限定名
     */
    private String modelClassName;


    public BasicTemplateContext(TableModel table, String tablePrefix, ApplicationConfig applicationConfig) {

        if (table == null || applicationConfig == null) {
            throw new NullPointerException();
        }

        this.table = table;
        this.tablePrefix = tablePrefix;
        this.bizChName = table.getComments();
        this.bizEnName = StringUtil.underline2CamelCase(table.getName(), tablePrefix);
        this.bizEnBigName = StringUtil.firstCharUp(this.bizEnName);
        this.author = applicationConfig.author;
        PackageConfig packageConfig = applicationConfig.getPackageConfig();
        this.filePath = packageConfig.getModulePath() + packageConfig.getJavaPath() + packageConfig.getPackagePath() + packageConfig.getBizModulePath();
        this.packageName = packageConfig.getPackageName() + packageConfig.getBizModuleName();
        this.bizModulePath = packageConfig.getBizModulePath();
        this.modelClassName = packageName +".model."+ bizEnBigName;

    }

}
