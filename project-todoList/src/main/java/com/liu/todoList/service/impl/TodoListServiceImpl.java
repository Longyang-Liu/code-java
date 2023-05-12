package com.liu.todoList.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.todoList.domain.TodoList;
import com.liu.todoList.mapper.TodoListMapper;
import com.liu.todoList.service.ITodoListService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
        // 通过工作包ID筛选
        if(todoList.getPackId() != null && todoList.getPackId() != ""){
            wrapper.eq("pack_id", todoList.getPackId());
        }
        // 排序
        wrapper.select().orderByAsc("finish");
        wrapper.select().orderByDesc("id");
        Page<TodoList> todoListPage = todoListMapper.selectPage(page, wrapper);
        return todoListPage;
    }

    @Override
    public TodoList getById(Long id) {
        return todoListMapper.selectById(id);
    }

    @Override
    public Boolean addTodo(TodoList todoList) {
        todoList.setCreateTime(new Date());
        todoListMapper.insert(todoList);
        return true;
    }

    @Override
    public Boolean updateTodo(TodoList todoList) {
        LambdaUpdateWrapper<TodoList> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(TodoList::getId, todoList.getId())
                .set(TodoList::getMemo, todoList.getMemo())
                .set(TodoList::getContent, todoList.getContent())
                .set(TodoList::getFinish, todoList.getFinish())
                .set(TodoList::getFinishTime, todoList.getFinish() == 2 ? new Date() : null);
        todoListMapper.update(null, lambdaUpdateWrapper);
        return true;
    }

    @Override
    public Boolean deletedTodo(Long id) {
        todoListMapper.deleteById(id);
        return true;
    }


}
