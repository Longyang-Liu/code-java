package com.liu.mapStruct.service.impl;

import com.alibaba.fastjson.JSON;
import com.liu.mapStruct.domain.Person;
import com.liu.mapStruct.domain.PersonDto;
import com.liu.mapStruct.domain.UserDTO;
import com.liu.mapStruct.mapper.UserMapper;


public class BeanCopyServiceImpl {

    public static void main(String[] args) {
        Person person = newPerson();
        mapStruct(person);
        json2Json(person);
        springCopyProperties(person);
    }

    public static Person newPerson(){
        Person person = new Person();
        person.setId(1L);
        person.setNo("001");
        person.setName("Leroy");
        person.setAge(23);
        return person;
    }

    public static void mapStruct(Person person){
        System.out.println("mapStruct Begin");

        UserDTO userDTO = UserMapper.INSTANCE.toDTO(person);
        PersonDto personDto = UserMapper.INSTANCE.personToDTO(person);
        System.out.println(userDTO);
        System.out.println(personDto);

        System.out.println("mapStruct End");
    }

    public static void json2Json(Person person){
        System.out.println("Json2Json Begin");

        String strJson = JSON.toJSONString(person);
        UserDTO userDTO = JSON.parseObject(strJson, UserDTO.class);
        System.out.println(userDTO);

        System.out.println("Json2Json End");
    }


    public static void springCopyProperties(Person person){
        System.out.println("Json2Json Begin");

        UserDTO userDTO = new UserDTO();
        org.springframework.beans.BeanUtils.copyProperties(person, userDTO);
        System.out.println(userDTO);

        System.out.println("Json2Json End");
    }
}
