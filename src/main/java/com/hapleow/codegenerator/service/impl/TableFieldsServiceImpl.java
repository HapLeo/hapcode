package com.hapleow.codegenerator.service.impl;

import com.hapleow.codegenerator.dao.TableFieldsMapper;
import com.hapleow.codegenerator.service.ITableFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
