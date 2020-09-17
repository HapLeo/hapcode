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
     * html包路径
     */
    private String htmlPath = "src/main/webapp/WEB-INF/view/";

    /**
     * js包路径
     */
    private String jsPath = "src/main/webapp/static/modular/";

    /**
     * test包路径
     */
    private String testPath = "src/main/test/";

    /**
     * 包路径
     */
    private String packagePath = "com/longzhong/lzms/modular/";


    /**
     * 包名(类全限定名的前半部分)
     */
    private String packageName = "com.longzhong.lzms.modular.";

    /**
     * 模块名（业务模块，例如order）
     */
    private String bizModuleName = "corporation";

    /**
     * 模块路径（业务模块，例如order）
     */
    private String bizModulePath = "corporation/";

}
