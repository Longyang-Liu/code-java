package com.liu.trim.controller;

import com.alibaba.fastjson.JSONObject;
import com.liu.trim.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 测试接口
 *
 * @author xub
 * @date 2022/10/24 下午5:06
 */
@Slf4j
@RestController
public class ParamController {
    /**
     * 1、Get请求测试首尾去空格
     */
    @GetMapping(value = "/getTrim")
    public String getTrim(@RequestParam String username, @RequestParam String phone) {
        return username + "&" + phone;
    }
    /**
     * 2、Post方法测试首尾去空格
     */
    @PostMapping(value = "/postTrim")
    public String postTrim(@RequestParam String username, @RequestParam String phone) {
        return username + "&" + phone;
    }
    /**
     * 3、post方法 json入参 测试首尾去空格
     */
    @PostMapping(value = "/postJsonTrim")
    public String helloUser(@RequestBody UserDao userDO) {
        return JSONObject.toJSONString(userDO);
    }
}

