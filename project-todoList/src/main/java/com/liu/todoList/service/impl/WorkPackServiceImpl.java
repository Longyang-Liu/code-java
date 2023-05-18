package com.liu.todoList.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.todoList.domain.TodoList;
import com.liu.todoList.domain.WorkPack;
import com.liu.todoList.mapper.WorkPackMapper;
import com.liu.todoList.service.ITodoListService;
import com.liu.todoList.service.IWorkPackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class WorkPackServiceImpl extends ServiceImpl<WorkPackMapper, WorkPack> implements IWorkPackService {

    @Resource
    private WorkPackMapper workPackMapper;
    @Resource
    private ITodoListService todoListService;

    @Override
    public Page<WorkPack> getList(WorkPack workPack) {
        Page<WorkPack> page = new Page<> (1, 10);
        QueryWrapper<WorkPack> wrapper =new QueryWrapper<>();
        wrapper.select().orderByDesc("id");
        Page<WorkPack> workPackPage = workPackMapper.selectPage(page, wrapper);
        return workPackPage;
    }

    @Override
    public WorkPack getById(Long id) {
        return workPackMapper.selectById(id);
    }

    @Override
    public Boolean addWorkPack(WorkPack workPack) {
        workPack.setCreateTime(new Date());
        workPackMapper.insert(workPack);
        return true;
    }

    @Override
    public Boolean updateTodo(WorkPack workPack) {
        LambdaUpdateWrapper<WorkPack> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(WorkPack::getId, workPack.getId())
                .set(WorkPack::getName, workPack.getName());
        workPackMapper.update(null, lambdaUpdateWrapper);
        return true;
    }

    @Override
    public Boolean deletedTodo(Long id) {
        workPackMapper.deleteById(id);
        return true;
    }
}
