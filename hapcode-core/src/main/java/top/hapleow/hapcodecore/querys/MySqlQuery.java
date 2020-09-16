package top.hapleow.hapcodecore.querys;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
public class MySqlQuery extends AbstractDbQuery {

    @Override
    public String tablesSql() {
        return "show table status WHERE 1=1 ";
    }

    @Override
    public String tableFieldsSql(String tableName) {
        return "show full fields from ? ";
    }
}
