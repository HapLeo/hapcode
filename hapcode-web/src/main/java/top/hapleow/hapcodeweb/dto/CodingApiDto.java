package top.hapleow.hapcodeweb.dto;

import lombok.Data;

import java.util.List;

/**
 * @author wuyulin
 * @date 2020/11/3
 */
@Data
public class CodingApiDto {


    /**
     * 目标路径
     */
    private String destPath;

    /**
     * 表名称列表
     */
    private List<String> tableNames;

    /**
     * 接口描述
     */
    private String desc;

    /**
     * 请求url
     */
    private String url;

    /**
     * DTO绝对路径
     */
    private String dtoAbPath;

}
