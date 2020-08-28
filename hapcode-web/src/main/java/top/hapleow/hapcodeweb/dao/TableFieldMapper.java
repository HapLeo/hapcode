package top.hapleow.hapcodeweb.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
public interface TableFieldMapper {

    List<Map<String, Object>> getTableFields(@Param("sql") String sql);
}
