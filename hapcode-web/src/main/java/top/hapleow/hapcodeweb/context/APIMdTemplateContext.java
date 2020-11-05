package top.hapleow.hapcodeweb.context;

import lombok.Data;
import top.hapleow.hapcodecore.common.Cache;
import top.hapleow.hapcodecore.context.BasicTemplateContext;
import top.hapleow.hapcodecore.model.FieldModel;
import top.hapleow.hapcodeweb.dto.CodingApiDto;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * DAO模板模型
 * 用于向模板传输数据
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class APIMdTemplateContext extends BasicTemplateContext {

    /**
     * 请求传入的参数封装对象
     */
    private CodingApiDto dto;

    /**
     * DTO中的字段列表（即接口入参列表）
     */
    private List<Map<String, String>> dtoFieldList;

    /**
     * 表字段列表
     */
    private Collection<FieldModel> fieldList = Cache.FIELD_MODEL_MAP_CACHE.values();

}
