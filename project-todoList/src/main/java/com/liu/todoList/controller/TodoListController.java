package com.liu.todoList.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.todoList.domain.TodoList;
import com.liu.todoList.service.ITodoListService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
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
    @GetMapping("/getList")
    public Page<TodoList> getList(TodoList todoList){
        Page<TodoList> list = todoListService.getList(todoList);
        return list;
    }

    @GetMapping(value = "/{id}")
    public TodoList getInfo(@PathVariable("id") Long id)
    {
        return todoListService.getById(id);
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

    @DeleteMapping("/{id}")
    public Boolean deletedTodo(@PathVariable Long id)
    {
        log.info("todoId => {}", id);
        return todoListService.deletedTodo(id);
    }
}
