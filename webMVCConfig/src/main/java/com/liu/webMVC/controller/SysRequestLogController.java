package com.liu.webMVC.controller;


import com.liu.webMVC.domain.SysRequestLog;
import com.liu.webMVC.mapper.SysRequestLogMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/requestLog")
public class SysRequestLogController {

    @Resource
    private SysRequestLogMapper sysRequestLogMapper;

    @GetMapping(value = "/list")
    public String getRequestLogList() {
        String str = "";
        SysRequestLog sysRequestLog = new SysRequestLog();
        sysRequestLog.setIp("fdsklflsfds");
        return str;
    }
}
