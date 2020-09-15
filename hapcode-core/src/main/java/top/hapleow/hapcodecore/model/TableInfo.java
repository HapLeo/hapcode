package top.hapleow.hapcodecore.model;

import lombok.Data;

/**
 * 表字段（数据库模型）
 *
 * @author wuyulin
 * @date 2020/8/28
 */
@Data
public class TableInfo implements IDbModel{

    /**
     * 表名
     */
    private String TABLE_NAME;

    /**
     * 表说明
     */
    private String COMMENTS;


    /**
     * 转换成Java中的Model
     *
     * @return
     */
    @Override
    public TableModel convert2JavaModel() {

        TableModel tableModel = new TableModel();
        tableModel.setName(this.TABLE_NAME);
        tableModel.setComments(this.COMMENTS);

        return tableModel;
    }
}
