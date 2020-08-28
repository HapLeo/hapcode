package top.hapleow.hapcodecore.querys;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
public abstract class AbstractDbQuery {


    /**
     * 表
     *
     * @return
     */
    public abstract String tablesSql();

    /**
     * 指定表的字段
     *
     * @return
     */
    public abstract String tableFieldsSql();

}
