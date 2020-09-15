package top.hapleow.hapcodeweb.service;

import top.hapleow.hapcodecore.model.FieldModel;
import top.hapleow.hapcodecore.model.TableModel;

import java.util.List;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
public interface ITableInfoService {

    List<FieldModel> getTableFields(String tableName);

    List<TableModel> getTables();

}
