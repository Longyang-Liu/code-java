package com.liu.log.service.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogServiceImpl {
    public String lombokTest(){
        log.warn("lombok ->{} ", true);
        return "lombok";
    }
}
