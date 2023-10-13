package com.liu.EBean.controller;

import com.liu.EBean.domain.StudentDTO;
import com.liu.EBean.domain.User;
import io.ebean.Ebean;
import io.ebean.SqlRow;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/main")
public class TestEBeanController {


    @GetMapping("/add")
    public String testAdd(){
        User user = new User();
        long l = System.currentTimeMillis();
        user.setId(l);
        user.setName("name" + l);
        user.setAge(18);
        user.setMailNumber("32132@qq.com");
        user.save();

        return user.toString();
    }


    @GetMapping("/update")
    public void testUpdate(){
        User user = Ebean.find(User.class).where().eq("id", "1").findOne();
        if (user != null) {
            user.setName("new.email@example.com");
            user.update();  // 更新用户数据
        }
    }

    @GetMapping("/delete")
    public void testDelete(){
        User user = Ebean.find(User.class).where().eq("id", "1").findOne();
        if (user != null) {
            user.delete();  // 删除用户数据
        }
    }


    @GetMapping("/query")
    public String testQuery(){
        User foundUser = Ebean.find(User.class).where().eq("name", "name1697159487022").findOne();
        System.out.println(foundUser);
        return foundUser.toString();
    }

    @GetMapping("/queryList")
    public void testQueryList(){
        List<User> customers = Ebean.find(User.class)
                .where().eq("age", "18")
                .findList();
        System.out.println(customers);
    }

    @GetMapping("/select")
    public void testSelect(){
        String str = "select * from t_user;";
        List<SqlRow> list = Ebean.createSqlQuery(str).findList();
        System.out.println(list);
    }


    @GetMapping("/selectJoin")
    public String selectJoin(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from t_user tu ");
        stringBuilder.append("LEFT JOIN t_student ts ON tu.id = ts.user_id ");
        stringBuilder.append("WHERE ts.user_id = 111 ");
        List<SqlRow> list = Ebean.createSqlQuery(stringBuilder.toString()).findList();

        System.out.println(list.get(0));

        return list.get(0).toString();
    }



//    @GetMapping("/queryList")
//    public String testQueryList(){
//        List<User> list = Ebean.find(User.class).where().eq("name", "name1697159487022").findList();
//        System.out.println(list);
//        System.out.println(list.toString());
//        return list.toString();
//    }


//    @GetMapping("/queryList")
//    public String testQueryList(){
//        // 创建查询对象
//        Query<User> query = Ebean.createQuery(User.class);
//        query.where().eq("name", "name1697159487022");
//        List<User> userList = query.findList();
//
//        System.out.println(userList);
//        return userList.toString();
//    }


}
