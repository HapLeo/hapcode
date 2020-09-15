package top.hapleow.hapcodecore.factory;

import top.hapleow.hapcodecore.querys.IDbQuery;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库查询对象工厂
 *
 * @author wuyulin
 * @date 2020/9/15
 */
public class DbQueryFactory {


    private static final Map<String, String> dbMap = new HashMap<>();

    static {
        dbMap.put("sqlserver","top.hapleow.hapcodecore.querys.SqlServerQuery");
        dbMap.put("mysql","top.hapleow.hapcodecore.querys.MySqlQuery");
        dbMap.put("oracle","top.hapleow.hapcodecore.querys.OracleQuery");
    }

    public IDbQuery getDbQuery(String databaseUrl) {

        if (databaseUrl == null) {
            throw new NullPointerException();
        }

        String[] split = databaseUrl.split(":");
        if (split.length <= 1) {
            throw new RuntimeException("url error.");
        }
        String databaseName = split[1];
        String databaseClz = dbMap.get(databaseName);
        if (databaseClz == null) {
            throw new RuntimeException("database in url unsupported.");
        }
        Class aClass = null;
        try {
            aClass = Class.forName(databaseClz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("database in url unsupported.");
        }
        IDbQuery queryInstance = null;
        try {
            queryInstance = (IDbQuery) aClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return queryInstance;
    }
}
