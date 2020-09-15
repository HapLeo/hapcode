package top.hapleow.hapcodecore.model;

import lombok.Data;

import java.util.List;

/**
 * 表模型
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class TableModel implements IJavaModel{


    /**
     * 表名
     */
    private String name;

    /**
     * 表说明
     */
    private String comments;

    /**
     * 字段列表
     */
    private List<FieldModel> fields;
}
