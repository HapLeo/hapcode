package top.hapleow.hapcodeweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodecore.model.TableField;
import top.hapleow.hapcodecore.model.TableInfo;
import top.hapleow.hapcodecore.querys.SqlServerQuery;
import top.hapleow.hapcodeweb.dao.TableInfoMapper;
import top.hapleow.hapcodeweb.service.ITableInfoService;

import java.util.List;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
@Service
public class TableInfoServiceImpl implements ITableInfoService {

    @Autowired
    private TableInfoMapper tableInfoMapper;


    @Override
    public List<TableField> getTableFields(String tableName) {

        return tableInfoMapper.getTableFields(new SqlServerQuery().tableFieldsSql(tableName));
    }

    @Override
    public List<TableInfo> getTables() {
        return tableInfoMapper.getTables(new SqlServerQuery().tablesSql());
    }
}
