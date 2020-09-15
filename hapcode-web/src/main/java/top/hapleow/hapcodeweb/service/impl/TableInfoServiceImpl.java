package top.hapleow.hapcodeweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodecore.common.DbQueryFactory;
import top.hapleow.hapcodecore.model.TableField;
import top.hapleow.hapcodecore.model.TableInfo;
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
    public List<TableField> getTableFields(String tableName) {


        String sql = dbQueryFactory.getDbQuery(url).tableFieldsSql(tableName);
        return tableInfoMapper.getTableFields(sql);
    }

    @Override
    public List<TableInfo> getTables() {

        String sql = dbQueryFactory.getDbQuery(url).tablesSql();
        return tableInfoMapper.getTables(sql);
    }
}
