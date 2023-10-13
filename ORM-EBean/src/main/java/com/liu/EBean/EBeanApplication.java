package com.liu.EBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EBeanApplication {
    public static void main(String[] args) {
        SpringApplication.run(EBeanApplication.class, args);
        System.out.println("EBean启动成功");
    }
}
