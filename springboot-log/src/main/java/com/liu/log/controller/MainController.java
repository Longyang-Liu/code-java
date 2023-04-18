package com.liu.log.controller;

import com.liu.log.service.impl.LogServiceImpl;
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

    /**
     * @Description: 使用 @Slf4j 添加日志
     * @param 
     * @return: java.lang.String
     * @Author: Liu
     * @Date: 2023/4/18 18:16
    */
    @RequestMapping("/logLombokTest")
    public String logLombokTest(){
        LogServiceImpl logService = new LogServiceImpl();
        return logService.lombokTest();
    }
}
