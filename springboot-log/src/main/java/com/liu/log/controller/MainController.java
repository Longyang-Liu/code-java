package com.liu.log.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logTest")
public class MainController extends BaseController {

    @RequestMapping("/logTest")
    public String logTest(){
        int a = 1;
        logger.info("测试日志 -> {}", a);
        logger.warn("测试日志 -> {}", a);
        logger.error("测试日志 -> {}", a);
        logger.debug("测试日志 -> {}", a);
        logger.trace("测试日志 -> {}", a);
        return "success";
    }
}
