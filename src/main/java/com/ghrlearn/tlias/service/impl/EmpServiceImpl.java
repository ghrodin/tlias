package com.ghrlearn.tlias.service.impl;

import com.ghrlearn.tlias.mapper.EmpMapper;
import com.ghrlearn.tlias.pojo.Emp;
import com.ghrlearn.tlias.pojo.PageBean;
import com.ghrlearn.tlias.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;


    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {

        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行分页查询
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        // 获取分页结果
        Page<Emp> p = (Page<Emp>) empList;
        //封装PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public Emp get(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
    @Override
    public Emp login(Emp emp) {
//调用dao层功能：登录
        Emp loginEmp = empMapper.getByUsernameAndPassword(emp);
//返回查询结果给Controller
        return loginEmp;
    }
}
