package com.liu.rabbit.domain;

import lombok.Data;

@Data
public class RabbitMQ {

    private String host = "127.0.0.1";
    private Integer port = 5673;
    private String userName = "guest";
    private String passWord = "guest";
}
