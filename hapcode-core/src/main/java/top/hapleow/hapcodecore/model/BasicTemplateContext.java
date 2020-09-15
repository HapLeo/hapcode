package top.hapleow.hapcodecore.model;

import lombok.Data;

/**
 * 基础模板模型
 * 用于向模板传输数据
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class BasicTemplateContext {

    private String bizChName;

    private String bizEnBigName;

    private TableModel table;

}
