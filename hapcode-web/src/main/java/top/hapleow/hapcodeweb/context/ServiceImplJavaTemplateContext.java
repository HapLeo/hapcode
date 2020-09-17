package top.hapleow.hapcodeweb.context;

import lombok.Data;
import top.hapleow.hapcodecore.config.ApplicationConfig;
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
public class ServiceImplJavaTemplateContext extends BasicTemplateContext {



    /**
     * 包名
     */
    private String packageName;

    private String subPackageName = "service/impl/";


    public ServiceImplJavaTemplateContext(TableModel table, String tablePrefix, ApplicationConfig applicationConfig) {
        super(table, tablePrefix, applicationConfig);
        this.packageName = applicationConfig.getPackageConfig().getPackageName() + "service.impl";
        this.setFileName(super.getBizEnBigName() +"ServiceImpl.java");
        this.setFilePath(getFilePath() + subPackageName);
    }

}
