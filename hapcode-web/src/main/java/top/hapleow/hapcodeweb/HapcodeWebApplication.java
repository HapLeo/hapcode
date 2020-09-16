package top.hapleow.hapcodeweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "top.hapleow.hapcodeweb.dao")
public class HapcodeWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(HapcodeWebApplication.class, args);
    }

}
