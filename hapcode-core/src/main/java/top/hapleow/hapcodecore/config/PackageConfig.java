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
    private String modulePath = "D:\\workspace\\aiwoplatformat\\sys-base\\user-manage-server\\";

    /**
     * java包路径
     */
    private String javaPath = "src/main/java/";

    /**
     * resources 目录
     */
    private String resourcesPath = "src/main/resources/";

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
    //private String packagePath = "com/longzhong/lzcs/modular/";
    private String packagePath = "com/jbs/";



    /**
     * 包名(类全限定名的前半部分)
     */
    private String packageName = "com.jbs.";

    /**
     * 模块名（业务模块，例如order）
     */
    private String bizModuleName = "usermanage";

    /**
     * 模块路径（业务模块，例如order）
     */
    private String bizModulePath = "usermanage/";


    public void setBizModuleName(String bizModuleName){
        this.bizModuleName = bizModuleName;
        this.bizModulePath = bizModuleName + "/";
    }

}
