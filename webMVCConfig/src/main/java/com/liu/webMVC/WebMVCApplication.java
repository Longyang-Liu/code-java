package com.liu.webMVC;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liu.webMVC.mapper")
public class WebMVCApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebMVCApplication.class, args);
        System.out.println("WebMVC启动成功");
    }
}
