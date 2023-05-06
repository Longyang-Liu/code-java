package com.liu.todoList.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.todoList.domain.TodoList;
import com.liu.todoList.service.ITodoListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/todoList")
public class TodoListController {

    @Resource
    private ITodoListService todoListService;

    /**
     * @Description: 查询数据接口
     * @param todoList
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.liu.todoList.domain.TodoList>
     * @Author: Liu
     * @Date: 2023/5/6 16:32
    */
    @RequestMapping("/getList")
    public Page<TodoList> getList(TodoList todoList){
        Page<TodoList> list = todoListService.getList(todoList);
        return list;
    }

    @PostMapping("/addTodo")
    public Boolean addTodo(@RequestBody TodoList todoList){
        todoListService.addTodo(todoList);
        return true;
    }

    @PutMapping("/updateTodo")
    public Boolean updateTodo(@RequestBody TodoList todoList){
        todoListService.updateTodo(todoList);
        return true;
    }
}
