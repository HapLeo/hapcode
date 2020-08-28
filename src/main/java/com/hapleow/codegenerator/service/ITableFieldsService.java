package com.hapleow.codegenerator.service;

import java.util.List;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
public interface ITableFieldsService {

    List<Map<String, Object>> getTableFields(String tableName);
}
