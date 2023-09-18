package com.liu.trim.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDao implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;
}
