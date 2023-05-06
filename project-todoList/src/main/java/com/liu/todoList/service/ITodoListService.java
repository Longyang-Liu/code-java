package com.liu.todoList.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.todoList.domain.TodoList;

public interface ITodoListService extends IService<TodoList> {

    /**
     * @Description: 获取所有的待办任务
     * @param todoList
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.liu.todoList.domain.TodoList>
     * @Author: Liu
     * @Date: 2023/5/6 16:10
    */
    Page<TodoList> getList(TodoList todoList);
    
    /**
     * @Description: 新增任务
     * @param todoList
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.liu.todoList.domain.TodoList>
     * @Author: Liu
     * @Date: 2023/5/6 16:38
    */
    Boolean addTodo(TodoList todoList);
    
    /**
     * @Description: 修改任务
     * @param todoList
     * @return: com.liu.todoList.domain.TodoList
     * @Author: Liu
     * @Date: 2023/5/6 16:39
    */
    Boolean updateTodo(TodoList todoList);
    
    /**
     * @Description: 删除任务
     * @param todoList
     * @return: com.liu.todoList.domain.TodoList
     * @Author: Liu
     * @Date: 2023/5/6 16:39
    */
    Boolean deletedTodo(TodoList todoList);
}
