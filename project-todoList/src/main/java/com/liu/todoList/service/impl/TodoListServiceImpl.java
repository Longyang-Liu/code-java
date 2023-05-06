package com.liu.todoList.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.todoList.domain.TodoList;
import com.liu.todoList.mapper.TodoListMapper;
import com.liu.todoList.service.ITodoListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TodoListServiceImpl extends ServiceImpl<TodoListMapper, TodoList> implements ITodoListService
{

    @Resource
    private TodoListMapper todoListMapper;

    @Override
    public Page<TodoList> getList(TodoList todoList) {
        Page<TodoList> page = new Page<> (1, 10);
        QueryWrapper<TodoList> wrapper =new QueryWrapper<>();
        Page<TodoList> todoListPage = todoListMapper.selectPage(page, wrapper);
        log.info("todoList");
        for (TodoList record : todoListPage.getRecords()) {
            System.out.println(record);
        }
        return todoListPage;
    }
}
