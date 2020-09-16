package top.hapleow.hapcodecore.model;

import lombok.Data;

/**
 * 字段模型
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class FieldModel implements IJavaModel{

    /**
     * 列名(DB)
     */
    private String columnName;

    /**
     * 字段名(JAVA)
     */
    private String propertyName;

    /**
     * 是否是唯一
     */
    private boolean isIdentity;

    /**
     * 键类型
     */
    private String key;

    /**
     * 数据类型
     */
    private String javaType;

    /**
     * 字段说明
     */
    private String comment;
}
