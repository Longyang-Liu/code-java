package com.liu.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@MapperScan("com.liu.base.mapper")
public class ProjectArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectArticleApplication.class, args);
        System.out.println("ProjectArticleApplication启动成功");
    }
}
