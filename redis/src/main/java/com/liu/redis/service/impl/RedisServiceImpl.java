package com.liu.redis.service.impl;


import com.liu.redis.util.RedisFactory;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisServiceImpl {

    private static Jedis jedis = RedisFactory.jedisFactory();


    private void getKeys(){
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("--------------");
    }


    public static void main(String[] args) {
        RedisServiceImpl impl = new RedisServiceImpl();
        impl.getKeys();
    }

}
