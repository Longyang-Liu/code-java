package com.liu.EBean.domain;


import io.ebean.Model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "t_user")
public class User extends Model {

    private Long id;
    private String name;

    private Integer age;
    private String mailNumber;
}
