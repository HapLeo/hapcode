package top.hapleow.hapcodecore.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyulin
 * @date 2020/9/15
 */
public class TypeConverter {

    private static Map<String, String> typeMap = new HashMap<>();

    static {

        // String
        typeMap.put("nvarchar", "String");
        typeMap.put("varchar", "String");
        typeMap.put("char", "String");
        typeMap.put("varchar2", "String");
        typeMap.put("uniqueidentifier", "String");

        // Integer
        typeMap.put("int", "Integer");
        typeMap.put("bit", "Integer");
        typeMap.put("tinyint", "Integer");

        // Long
        typeMap.put("bigint", "Long");

        // LocalDate
        typeMap.put("date", "LocalDate");

        // LocalDateTime
        typeMap.put("datetime", "LocalDateTime");

        // Double
        typeMap.put("decimal", "Double");
        typeMap.put("number", "Double");
        typeMap.put("float", "Double");

    }

    public static String db2Java(String dbType) {

        return typeMap.get(dbType);
    }
}
