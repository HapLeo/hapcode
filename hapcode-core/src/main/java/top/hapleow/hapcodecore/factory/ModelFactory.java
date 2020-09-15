package top.hapleow.hapcodecore.factory;

import top.hapleow.hapcodecore.model.FieldModel;
import top.hapleow.hapcodecore.model.TableField;
import top.hapleow.hapcodecore.model.TableInfo;
import top.hapleow.hapcodecore.model.TableModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 模型工厂
 *
 * @author wuyulin
 * @date 2020/9/15
 */
public class ModelFactory {


    /**
     * 数据库模型列表转换成Java模型列表
     *
     * @param dbModels
     * @return
     */
    public static List<TableModel> tableInfoToModel(List<TableInfo> dbModels) {

        ArrayList<TableModel> tableModels = new ArrayList<>();
        for (TableInfo dbModel : dbModels) {

            tableModels.add(dbModel.convert2JavaModel());
        }

        return tableModels;
    }

    /**
     * 数据库模型列表转换成Java模型列表
     *
     * @param dbModels
     * @return
     */
    public static List<FieldModel> tableFieldToModel(List<TableField> dbModels) {

        ArrayList<FieldModel> tableModels = new ArrayList<>();
        for (TableField dbModel : dbModels) {

            tableModels.add(dbModel.convert2JavaModel());
        }

        return tableModels;
    }

}
