package top.hapleow.hapcodecore.common;

import top.hapleow.hapcodecore.model.TableModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuyulin
 * @date 2020/9/16
 */
public class Cache {

    public static final Map<String, TableModel> TABLE_MODEL_CACHE = new ConcurrentHashMap<>();

}
