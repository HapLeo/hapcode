package top.hapleow.hapcodeweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.hapleow.hapcodecore.factory.DbQueryFactory;
import top.hapleow.hapcodecore.factory.ModelFactory;
import top.hapleow.hapcodecore.generator.BeetlGenerator;
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

    @Autowired
    private BeetlGenerator beetlGenerator;

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
}
