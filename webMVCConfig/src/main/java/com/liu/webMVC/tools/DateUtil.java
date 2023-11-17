package com.liu.webMVC.tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static String getNowTimeStr(){
        // 获取当前时间
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化当前时间为字符串
        String formattedDateTime = currentDateTime.format(formatter);

        // 输出格式化后的时间字符串
        System.out.println("Current Time: " + formattedDateTime);
        return formattedDateTime;
    }

    public static Date getNowTime(){
        Date date = new Date();
        return date;
    }
}
