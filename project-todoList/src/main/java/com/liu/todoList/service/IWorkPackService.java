package com.liu.todoList.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.todoList.domain.TodoList;
import com.liu.todoList.domain.WorkPack;

public interface IWorkPackService extends IService<WorkPack> {

    Page<WorkPack> getList(WorkPack workPack);

    WorkPack getById(Long id);

    Boolean addWorkPack(WorkPack workPack);

    Boolean updateTodo(WorkPack workPack);

    Boolean deletedTodo(Long id);
}
