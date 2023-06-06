package com.liu.mapStruct.domain;


import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String No;

    private String name;
    private String nickName;

    private Integer userAge;
    private Integer age;
}
