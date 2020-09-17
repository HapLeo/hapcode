package top.hapleow.hapcodeweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodecore.common.Cache;
import top.hapleow.hapcodecore.factory.DbQueryFactory;
import top.hapleow.hapcodecore.factory.ModelFactory;
import top.hapleow.hapcodecore.model.FieldModel;
import top.hapleow.hapcodecore.model.TableModel;
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

    @Autowired
    private DbQueryFactory dbQueryFactory;


    @Value("${spring.datasource.url}")
    private String url;

    @Override
    public List<FieldModel> getTableFields(String tableName) {


        String sql = dbQueryFactory.getDbQuery(url).tableFieldsSql(tableName);

        return ModelFactory.tableFieldToModel(tableInfoMapper.getTableFields(sql));
    }

    @Override
    public List<TableModel> getTables() {

        String sql = dbQueryFactory.getDbQuery(url).tablesSql();
        return ModelFactory.tableInfoToModel(tableInfoMapper.getTables(sql));
    }

    @Override
    public TableModel getTableModel(String tableName) {

        TableModel tableModel = Cache.TABLE_MODEL_CACHE.get(tableName);
        if (tableModel == null) {
            synchronized (Cache.TABLE_MODEL_CACHE) {
                tableModel = Cache.TABLE_MODEL_CACHE.get(tableName);
                if (tableModel == null) {
                    List<TableModel> tables = getTables();
                    tables.forEach(item -> {
                        Cache.TABLE_MODEL_CACHE.put(item.getName(), item);
                    });
                }
            }
        }
        TableModel cacheModel = Cache.TABLE_MODEL_CACHE.get(tableName);
        if (cacheModel != null) {
            List<FieldModel> fields = cacheModel.getFields();
            if (fields == null) {
                synchronized (Cache.TABLE_MODEL_CACHE) {
                    if (cacheModel.getFields() == null) {
                        cacheModel.setFields(getTableFields(tableName));
                    }
                }
            }
        }

        return cacheModel;
    }
}
