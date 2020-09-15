package top.hapleow.hapcodeweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import top.hapleow.hapcodecore.common.DbQueryFactory;

/**
 * 数据库查询工厂配置类
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Component
public class DbQueryFactoryConfig {

    @Bean
    public DbQueryFactory getDbQueryFactory() {

        return new DbQueryFactory();
    }
}
