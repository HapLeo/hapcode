package top.hapleow.hapcodecore.generator;

import top.hapleow.hapcodecore.config.ApplicationConfig;
import top.hapleow.hapcodecore.model.TableModel;

/**
 * 生成器接口
 *
 * @author wuyulin
 * @date 2020/9/16
 */
public interface IGenerator {

    void execute(String templateName, TableModel templateContext, ApplicationConfig applicationConfig);

}

