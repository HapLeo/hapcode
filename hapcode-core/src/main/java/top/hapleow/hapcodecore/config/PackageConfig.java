package top.hapleow.hapcodecore.config;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 包配置
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
@Component
public class PackageConfig {

    /**
     * 模块根路径
     */
    private String modulePath = "C:\\ideaSpace\\lzms\\lzms-admin\\";

    /**
     * java包路径
     */
    private String javaPath = "src/main/java/";

    /**
     * test包路径
     */
    private String testPath = "src/main/test/";

    /**
     * 包路径
     */
    private String packagePath = "com/longzhong/lzms/modular/corporation/";


    /**
     * 包名(类全限定名的前半部分)
     */
    private String packageName = "com.longzhong.lzms.modular.corporation.";

}
