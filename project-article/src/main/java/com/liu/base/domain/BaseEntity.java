package com.liu.base.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class BaseEntity {
    Long pageNum;
    Long pageSize;
}
