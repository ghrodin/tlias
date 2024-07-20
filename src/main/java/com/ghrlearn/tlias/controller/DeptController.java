package com.ghrlearn.tlias.controller;

import com.ghrlearn.tlias.pojo.Dept;
import com.ghrlearn.tlias.pojo.Result;
import com.ghrlearn.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("查询所有部门数据");
        List<Dept> deptlist = deptService.list();
        return Result.success(deptlist);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门");
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门: {}", dept);
        deptService.add(dept);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("根据id修改部门");
        deptService.update(dept);
        return Result.success(dept);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据id查询部门");
        Dept dept = deptService.get(id);
        return Result.success(dept);
    }
}
