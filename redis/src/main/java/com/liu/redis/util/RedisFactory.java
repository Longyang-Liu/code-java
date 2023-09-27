package com.liu.redis.util;

import redis.clients.jedis.Jedis;

public class RedisFactory {

    private final static String redisIP = "127.0.0.1";
    private final static Integer redisPort = 6379;


    public static Jedis jedisFactory(){
        Jedis jedis = new Jedis(redisIP,redisPort);
        return jedis;
    }
}
