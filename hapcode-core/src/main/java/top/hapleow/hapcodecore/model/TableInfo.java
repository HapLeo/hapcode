package top.hapleow.hapcodecore.model;

import lombok.Data;

/**
 * 表字段（数据库模型）
 *
 * @author wuyulin
 * @date 2020/8/28
 */
@Data
public class TableInfo {

    /**
     * 表名
     */
    private String TABLE_NAME;

    /**
     * 字段说明
     */
    private String COMMENTS;


}
