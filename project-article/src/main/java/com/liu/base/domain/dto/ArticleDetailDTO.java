package com.liu.base.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/***
* @Description: 文章详细数据DTO
* @Param:
* @return:
* @Author: Liu
* @Date: 2023/1/10 18:49
*/
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class ArticleDetailDTO {

    String articleId;
    String articleTitle;
    String articleContent;
    String articleDescription;
    String createdBy;
    String creatorNo;
    String iseq;
    Date creationTime;
}
