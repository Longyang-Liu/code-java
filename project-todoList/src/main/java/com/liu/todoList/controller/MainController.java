package com.liu.todoList.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.todoList.domain.TodoList;
import com.liu.todoList.service.ITodoListService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/main")
public class MainController {

    @Resource
    private ITodoListService todoListService;

    @RequestMapping("/test")
    public String test(){
        TodoList todoList = new TodoList();
        Page<TodoList> list = todoListService.getList(todoList);
        return "success";
    }
}
