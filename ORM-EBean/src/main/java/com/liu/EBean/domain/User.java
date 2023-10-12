package com.liu.EBean.domain;


import lombok.Data;

import javax.persistence.Table;

@Data
@Table(catalog = "t_user")
public class User extends BaseModel {

    private String name;
    private Integer age;
}
