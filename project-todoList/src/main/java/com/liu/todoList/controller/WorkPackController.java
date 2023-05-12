package com.liu.todoList.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.todoList.domain.TodoList;
import com.liu.todoList.domain.WorkPack;
import com.liu.todoList.service.IWorkPackService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/workPack")
public class WorkPackController {

    @Resource
    private IWorkPackService workPackService;

    @RequestMapping("/getList")
    public Page<WorkPack> getList(WorkPack workPack){
        Page<WorkPack> list = workPackService.getList(workPack);
        return list;
    }

    @GetMapping(value = "/{id}")
    public WorkPack getInfo(@PathVariable("id") Long id)
    {
        return workPackService.getById(id);
    }

    @PostMapping("/addWorkPack")
    public Boolean addWorkPack(@RequestBody WorkPack workPack){
        workPackService.addWorkPack(workPack);
        return true;
    }

    @PutMapping("/updateWorkPack")
    public Boolean updateTodo(@RequestBody WorkPack workPack){
        workPackService.updateTodo(workPack);
        return true;
    }

    @DeleteMapping("/{id}")
    public Boolean deletedTodo(@PathVariable Long id)
    {
        return workPackService.deletedTodo(id);
    }
}
