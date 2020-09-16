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


    /**
     * 转换成Java中的Model
     *
     * @return
     */
    @Override
    public FieldModel convert2JavaModel() {

        FieldModel fieldModel = new FieldModel();
        fieldModel.setColumnName(this.COLUMN_NAME);
        fieldModel.setPropertyName(StringUtil.underline2CamelCase(this.COLUMN_NAME));
        fieldModel.setIdentity(isIdentity);
        fieldModel.setKey(this.KEY);
        fieldModel.setJavaType(TypeConverter.db2Java(this.DATA_TYPE));
        fieldModel.setComment(this.COMMENTS);

        return fieldModel;
    }
}
