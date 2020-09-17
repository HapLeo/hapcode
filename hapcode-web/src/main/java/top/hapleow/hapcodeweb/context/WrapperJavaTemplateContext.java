package top.hapleow.hapcodeweb.context;

import lombok.Data;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.context.BasicTemplateContext;
import top.hapleow.hapcodecore.model.TableModel;

import java.io.File;

/**
 * 视图包装器模板容器
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class WrapperJavaTemplateContext extends BasicTemplateContext {


    private String subPackageName = "wrapper" + File.separator;

    public WrapperJavaTemplateContext(TableModel table, String tablePrefix, ApplicationConfig applicationConfig) {
        super(table, tablePrefix, applicationConfig);
        this.setFileName(super.getBizEnBigName() + "Wrapper.java");
        this.setFilePath(getFilePath() + subPackageName);
        this.setPackageName(super.getPackageName() + ".wrapper");
    }

}
