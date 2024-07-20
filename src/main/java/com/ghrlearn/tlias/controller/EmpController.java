package com.ghrlearn.tlias.controller;

import com.ghrlearn.tlias.pojo.Emp;
import com.ghrlearn.tlias.pojo.PageBean;
import com.ghrlearn.tlias.pojo.Result;
import com.ghrlearn.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息");
        empService.update(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("根据id查询员工，id：{}",id);
        Emp emp=empService.get(id);
        return Result.success(emp);
    }
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工，员工信息：{}",emp);
        empService.save(emp);
        return Result.success();
    }
    @GetMapping
    public Result Page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        //记录日志
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        //调用业务层分页查询功能
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除，ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }
}
