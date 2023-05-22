package com.liu.base.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: 文章图片实体类
 * @param
 * @return:
 * @Author: Liu
 * @Date: 2023/1/31 14:11
*/
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
@TableName("article_img")
public class ArticleImg {

    @TableField("id")
    String id;

    @TableField("name")
    String name;

    @TableField("type")
    String type;

    @TableField("url")
    String url;

    @TableField("path")
    String path;

    @TableField("size")
    Long size;

    @TableField("upload_time")
    Date uploadTime;

}
