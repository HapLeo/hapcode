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
    private String modulePath = "C:\\workspace\\hapcode\\hapcode-core\\";

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
    private String packagePath = "top/hapleow/";


    /**
     * 包名(类全限定名的前半部分)
     */
    private String packageName = "top.hapleow";

}
