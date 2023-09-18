package com.liu.trim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  启动类
 *
 * @author xub
 * @date 2022/10/24 上午11:22
 */
@SpringBootApplication
public class TrimApplication  {

    public static void main(String[] args) {
        SpringApplication.run(TrimApplication .class, args);
        System.out.println("TrimApplication启动成功");
    }
}
