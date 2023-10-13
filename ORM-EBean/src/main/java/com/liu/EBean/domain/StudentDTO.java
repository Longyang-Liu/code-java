package com.liu.EBean.domain;


import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    private String name;

    private Integer age;
    private String mailNumber;

    private String school;
}
