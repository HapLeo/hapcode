package top.hapleow.hapcodeweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodecore.querys.SqlServerQuery;
import top.hapleow.hapcodeweb.dao.TableFieldMapper;
import top.hapleow.hapcodeweb.service.ITableFieldService;

import java.util.List;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
@Service
public class TableFieldServiceImpl implements ITableFieldService {

    @Autowired
    private TableFieldMapper tableFieldMapper;

    @Override
    public List<Map<String, Object>> getTableFields(String tableName) {

        return tableFieldMapper.getTableFields(new SqlServerQuery().tableFieldsSql(tableName));
    }
}
