package top.hapleow.hapcodecore.model;

import lombok.Data;

/**
 * 表字段（数据库模型）
 *
 * @author wuyulin
 * @date 2020/8/28
 */
@Data
public class TableField {

    /**
     * 表名
     */
    private String TABLE_NAME;

    /**
     * 列名
     */
    private String COLUMN_NAME;

    /**
     * 是否是唯一
     */
    private boolean isIdentity;

    /**
     * 键类型
     */
    private String KEY;

    /**
     * 数据类型
     */
    private String DATA_TYPE;

    /**
     * 字段说明
     */
    private String COMMENTS;


}
