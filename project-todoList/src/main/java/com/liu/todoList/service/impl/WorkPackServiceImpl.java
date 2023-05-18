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
import java.text.DecimalFormat;
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
        // 工作包进度设置
        setPackProgress(workPackPage.getRecords());
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
        lambdaUpdateWrapper.eq(WorkPack::getId, workPack.getId());
        if(workPack.getName() != null ){
            lambdaUpdateWrapper.set(WorkPack::getName, workPack.getName());
        }
        if(workPack.getMemo() != null ){
            lambdaUpdateWrapper.set(WorkPack::getMemo, workPack.getMemo());
        }
        workPackMapper.update(null, lambdaUpdateWrapper);
        return true;
    }

    @Override
    public Boolean deletedTodo(Long id) {
        workPackMapper.deleteById(id);
        return true;
    }


    /**
     * @Description: 设置工作包进度
     * @param list
     * @return: void
     * @Author: Liu
     * @Date: 2023/5/18 9:59
    */
    public void setPackProgress(List<WorkPack> list){
        TodoList todoList;
        for (WorkPack workPack : list) {
            log.info("workPack.getId() -> {}", workPack.getId());
            todoList = new TodoList();
            todoList.setPackId(workPack.getId());
            Page<TodoList> list1 = todoListService.getList(todoList);
            workPack.setProgress(getProgress(list1.getRecords()));
        }
    }

    /**
     * @Description: 获取工作包进度
     * @param lists
     * @return: java.lang.Double
     * @Author: Liu
     * @Date: 2023/5/18 11:28
    */
    public Double getProgress(List<TodoList> lists){
        if(lists != null && lists.size() > 0){
            int count = 0;
            for (TodoList todo : lists) {
                if(todo.getFinish().equals(2)){
                    count += 1;
                }
            }
            double number = (double) count / lists.size();
            DecimalFormat df = new DecimalFormat("#");
            String result = df.format(number* 100);
            double roundedNumber = Double.parseDouble(result);
            log.info("count / lists.size() -> {}", roundedNumber);
            return roundedNumber;
        }
        return (double)0;
    }
}
