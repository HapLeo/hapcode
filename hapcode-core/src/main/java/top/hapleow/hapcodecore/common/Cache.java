package top.hapleow.hapcodecore.common;

import top.hapleow.hapcodecore.model.FieldModel;
import top.hapleow.hapcodecore.model.TableModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuyulin
 * @date 2020/9/16
 */
public class Cache {

    /**
     * 表名称与表模型对象映射缓存
     */
    public static final Map<String, TableModel> TABLE_MODEL_CACHE = new ConcurrentHashMap<>();

    /**
     * 字段名称与字段模型对象映射缓存
     */
    public static final Map<String, FieldModel> FIELD_MODEL_MAP_CACHE = new ConcurrentHashMap<>();
}
