package top.hapleow.hapcodecore.model;

import lombok.Data;
import top.hapleow.hapcodecore.common.StringUtil;

/**
 * 基础模板模型
 * 用于向模板传输数据
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class BasicTemplateContext {

    private String bizChName;

    private String bizEnName;

    private String bizEnBigName;

    private String tablePrefix;

    private TableModel table;



    public BasicTemplateContext(TableModel table, String tablePrefix) {
        if (table == null) {
            throw new NullPointerException();
        }
        this.table = table;
        this.tablePrefix = tablePrefix;
        this.bizChName = table.getComments();
        this.bizEnName = StringUtil.underline2CamelCase(table.getName(), tablePrefix);
        this.bizEnBigName = StringUtil.firstCharUp(this.bizEnName);
    }

}
