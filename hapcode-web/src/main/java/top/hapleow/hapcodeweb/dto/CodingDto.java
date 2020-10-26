package top.hapleow.hapcodeweb.dto;

import lombok.Data;

/**
 * @author wuyulin
 * @date 2020/10/26
 */
@Data
public class CodingDto {

    /**
     * @desc 表名称
     */
    private String tableName;

    /**
     * @desc 模块名称
     */
    private String bizModuleName;

    /**
     * 模板名称
     */
    private String templateKey;

    /**
     * 作者
     */
    private String author;
}
