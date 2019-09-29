package com.mars.elleshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.mars.elleshop.dao") //扫描dao层, 与数据类型绑定相关
@ServletComponentScan // 将 filter 交给spring管理
public class ElleshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElleshopApplication.class, args);
    }

}
