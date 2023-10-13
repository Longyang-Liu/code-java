package com.liu.mongodb.controller;

import com.liu.mongodb.service.impl.MongoCredentialImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/main")
public class TestController {

    @Resource
    MongoCredentialImpl mongoCredential;

    @GetMapping("/test1")
    public String test1(){
        return "success";
    }

    @GetMapping("/test")
    public void test(){
        mongoCredential.createUser();
    }

    @GetMapping("/findUserList")
    public void findUserList(){
        mongoCredential.findUserList();
    }

}
