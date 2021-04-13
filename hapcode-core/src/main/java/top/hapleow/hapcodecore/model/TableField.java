package top.hapleow.hapcodecore.model;

import lombok.Data;
import top.hapleow.hapcodecore.common.StringUtil;
import top.hapleow.hapcodecore.common.TypeConverter;

/**
 * 表字段（数据库模型）
 *
 * @author wuyulin
 * @date 2020/8/28
 */
@Data
public class TableField implements IDbModel {


    /**
     * 列名
     */
    private String field;


    /**
     * 键类型
     */
    private String KEY;

    /**
     * 数据类型
     */
    private String type;

    /**
     * 字段说明
     */
    private String comment;


    /**
     * 转换成Java中的Model
     *
     * @return
     */
    @Override
    public FieldModel convert2JavaModel() {

        FieldModel fieldModel = new FieldModel();
        fieldModel.setColumnName(this.field);
        fieldModel.setPropertyName(StringUtil.underline2CamelCase(this.field));
        fieldModel.setKey(this.KEY);
        fieldModel.setJavaType(TypeConverter.db2Java(this.type));
        fieldModel.setComment(this.comment);

        return fieldModel;
    }
}
