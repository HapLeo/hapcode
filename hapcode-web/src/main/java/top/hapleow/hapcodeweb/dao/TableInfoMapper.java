package top.hapleow.hapcodeweb.dao;

import org.apache.ibatis.annotations.Param;
import top.hapleow.hapcodecore.model.TableField;
import top.hapleow.hapcodecore.model.TableInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
public interface TableInfoMapper {

    List<TableField> getTableFields(@Param("sql") String sql);

    List<TableInfo> getTables(@Param("sql") String sql);
}
