package com.liu.mapStruct.mapper;

import com.liu.mapStruct.domain.Person;
import com.liu.mapStruct.domain.PersonDto;
import com.liu.mapStruct.domain.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    // 多个 Mapping
    @Mappings({
            @Mapping(source = "age", target = "userAge"),
            @Mapping(source = "name", target = "nickName")
    })

//    // 单个Mapping
//    @Mapping(source = "name", target = "nickName")
    UserDTO toDTO(Person person);

    @Mapping(source = "name", target = "mc")
    PersonDto personToDTO(Person person);
}
