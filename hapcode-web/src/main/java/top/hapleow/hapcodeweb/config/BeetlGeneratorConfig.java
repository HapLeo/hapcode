package top.hapleow.hapcodeweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import top.hapleow.hapcodecore.generator.BeetlGenerator;

/**
 * Beetl生成器配置
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Component
public class BeetlGeneratorConfig {

    @Bean
    public BeetlGenerator getBeetlGenerator() {
        return new BeetlGenerator();
    }
}
