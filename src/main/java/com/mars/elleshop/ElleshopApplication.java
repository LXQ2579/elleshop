package com.mars.elleshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
@MapperScan("com.mars.elleshop.dao") //扫描dao层, 与数据类型绑定相关
//@ServletComponentScan // 将 filter 交给spring管理
public class ElleshopApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ElleshopApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ElleshopApplication.class, args);
    }

}
