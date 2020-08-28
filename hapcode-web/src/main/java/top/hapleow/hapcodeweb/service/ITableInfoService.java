package top.hapleow.hapcodeweb.service;

import top.hapleow.hapcodecore.model.TableField;
import top.hapleow.hapcodecore.model.TableInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
public interface ITableInfoService {

    List<TableField> getTableFields(String tableName);

    List<TableInfo> getTables();

}
