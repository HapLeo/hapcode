package top.hapleow.hapcodeweb.context;

import lombok.Data;
import top.hapleow.hapcodecore.common.Cache;
import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.context.BasicTemplateContext;
import top.hapleow.hapcodecore.model.FieldModel;
import top.hapleow.hapcodecore.model.TableModel;

import java.io.File;
import java.util.Collection;
import java.util.Set;

/**
 * DAO模板模型
 * 用于向模板传输数据
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class APIMdTemplateContext extends BasicTemplateContext{


    private Collection <FieldModel> fieldList = Cache.FIELD_MODEL_MAP_CACHE.values();

}
