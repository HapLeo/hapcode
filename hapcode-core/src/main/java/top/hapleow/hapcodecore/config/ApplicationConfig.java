package top.hapleow.hapcodecore.config;

import lombok.Data;

/**
 * @author wuyulin
 * @date 2020/9/16
 */
@Data
public class ApplicationConfig {

    public String author = "wuyulin";
    private PackageConfig packageConfig = new PackageConfig();

}
