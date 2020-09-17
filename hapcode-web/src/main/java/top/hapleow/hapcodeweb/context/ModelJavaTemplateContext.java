package top.hapleow.hapcodeweb.context;

import lombok.Data;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.context.BasicTemplateContext;
import top.hapleow.hapcodecore.model.TableModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 基础模板模型
 * 用于向模板传输数据
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class ModelJavaTemplateContext extends BasicTemplateContext {

    /**
     * 包名
     */
    private String packageName;

    private String subPackageName = "model/";

    private List<String> imports = new ArrayList<>();


    public ModelJavaTemplateContext(TableModel table, String tablePrefix, ApplicationConfig applicationConfig) {
        super(table, tablePrefix, applicationConfig);
        this.packageName = applicationConfig.getPackageConfig().getPackageName() + "model";
        this.setFileName(super.getBizEnBigName() +".java");
        this.setFilePath(getFilePath() + subPackageName);


        table.getFields().forEach(item -> {
            String javaType = item.getJavaType();
            if (Objects.equals(javaType,"LocalDate")){
                imports.add("java.time.LocalDate");
            }
            if (Objects.equals(javaType,"LocalDateTime")){
                imports.add("java.time.LocalDateTime");
            }
        });
    }

}
