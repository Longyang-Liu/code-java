package com.liu.base.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
* @Description: 文章内容实体类
* @Param: 
* @return: 
* @Author: Liu
* @Date: 2023/1/10 19:01
*/
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
@TableName("article_content")
public class ArticleContent {

    @TableField("article_id")
    String articleId;
    @TableField("article_content")
    String articleContent;
}
