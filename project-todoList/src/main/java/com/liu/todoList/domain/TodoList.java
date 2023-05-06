package com.liu.todoList.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("todo_list")
public class TodoList {

    @TableField("id")
    String id;

    @TableField("pack_id")
    String packId;

    @TableField("content")
    String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    Date createTime;

    @TableField("finish")
    Integer finish;

    @TableField("finish_time")
    Date finishTime;

    @TableField("memo")
    String memo;


}
