package top.hapleow.hapcodecore.querys;

/**
 * 数据库表信息查询接口
 *
 * @author wuyulin
 * @date 2020/8/28
 */
public interface IDbQuery {

    /**
     * 表
     *
     * @return
     */
    String tablesSql();

    /**
     * 指定表的字段
     *
     * @return
     * @param tableName
     */
    String tableFieldsSql(String tableName);

}
