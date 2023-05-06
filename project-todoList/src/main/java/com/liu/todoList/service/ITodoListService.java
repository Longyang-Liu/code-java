package com.liu.todoList.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.todoList.domain.TodoList;

public interface ITodoListService extends IService<TodoList> {

    Page<TodoList> getList(TodoList todoList);
}
