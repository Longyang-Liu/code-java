package com.liu.todoList.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("todo_list")
public class TodoList {

    @TableField("id")
    String id;

    @TableField("pack_id")
    String packId;

    @TableField("content")
    String content;

    @TableField("create_time")
    String createTime;

    @TableField("finish")
    String finish;

    @TableField("finish_time")
    String finishTime;

    @TableField("memo")
    String memo;


}
