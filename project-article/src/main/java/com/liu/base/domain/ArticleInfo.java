package com.liu.base.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/***
* @Description: 文章信息实体类
* @Param: 
* @return: 
* @Author: Liu
* @Date: 2023/1/10 19:01
*/
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
@TableName("article_info")
public class ArticleInfo {

    @TableField("article_id")
    String articleId;

    @TableField("article_title")
    String articleTitle;

    @TableField("article_description")
    String articleDescription;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("creation_time")
    Date creationTime;

    @TableField("created_by")
    String createdBy;

    @TableField("creator_no")
    String creatorNo;
}
