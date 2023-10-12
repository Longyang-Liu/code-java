package com.liu.EBean.controller;

import com.liu.EBean.domain.User;
import io.ebean.Ebean;
import io.ebean.SqlRow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/main")
public class TestEBeanController {


    @GetMapping("/add")
    public void testAdd(){
        User user = new User();
        long l = System.currentTimeMillis();
        user.setName("name" + l);
        user.setAge(18);
        user.save();
    }

    @GetMapping("/select")
    public void testQuery(){

        String str = "select * from t_user;";

        List<SqlRow> list = Ebean.createSqlQuery(str).findList();
        System.out.println(list);
    }
}
