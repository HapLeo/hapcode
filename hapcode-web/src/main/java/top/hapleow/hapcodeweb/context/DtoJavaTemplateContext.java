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
public class DtoJavaTemplateContext extends BasicTemplateContext {


    private String subPackageName = "dto" + File.separator;

    public DtoJavaTemplateContext(TableModel table, String tablePrefix, ApplicationConfig applicationConfig) {
        super(table, tablePrefix, applicationConfig);
        this.setFileName(super.getBizEnBigName() + "Dto.java");
        this.setFilePath(getFilePath() + subPackageName);
        this.setPackageName(super.getPackageName() + ".dto");
    }

}
