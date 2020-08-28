package top.hapleow.hapcodeweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodeweb.dao.TableFieldsMapper;
import top.hapleow.hapcodeweb.service.ITableFieldsService;

import java.util.List;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
@Service
public class TableFieldsServiceImpl implements ITableFieldsService {

    @Autowired
    private TableFieldsMapper tableFieldsMapper;

    @Override
    public List<Map<String, Object>> getTableFields(String tableName) {

        return tableFieldsMapper.getTableFields(tableName);
    }
}
