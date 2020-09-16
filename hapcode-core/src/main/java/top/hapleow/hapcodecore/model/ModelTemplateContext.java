package top.hapleow.hapcodecore.model;

import lombok.Data;

/**
 * 基础模板模型
 * 用于向模板传输数据
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class ModelTemplateContext extends BasicTemplateContext {

    /**
     * 包名
     */
    private String packageName;


    public ModelTemplateContext(TableModel table, String tablePrefix, String packageName) {
        super(table, tablePrefix);
        this.packageName = packageName;
    }

}
