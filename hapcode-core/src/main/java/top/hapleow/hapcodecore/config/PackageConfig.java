package top.hapleow.hapcodecore.config;

import lombok.Data;

/**
 * 包配置
 *
 * @author wuyulin
 * @date 2020/9/15
 */
@Data
public class PackageConfig {

    /**
     * 模块根路径
     */
    private String modulePath;

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
    private String packagePath;


}
