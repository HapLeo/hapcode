package top.hapleow.hapcodeweb.context;

import lombok.Data;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.context.BasicTemplateContext;
import top.hapleow.hapcodecore.model.TableModel;

import java.io.File;

/**
 * DAO模板模型
 * 用于向模板传输数据
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class DaoJavaTemplateContext extends BasicTemplateContext {

    /**
     * 包名
     */
    private String packageName;

    private String subPackageName = "dao" + File.separator;

    public DaoJavaTemplateContext(TableModel table, String tablePrefix, ApplicationConfig applicationConfig) {
        super(table, tablePrefix, applicationConfig);
        this.setFileName(super.getBizEnBigName() + "Mapper.java");
        this.setFilePath(getFilePath() + subPackageName);
        this.setPackageName(applicationConfig.getPackageConfig().getPackageName() + "dao");
    }

}
