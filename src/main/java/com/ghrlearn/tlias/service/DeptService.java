package com.ghrlearn.tlias.service;

import com.ghrlearn.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> list();
    void delete(Integer id);
    void add(Dept dept);
    void update(Dept dept);
    Dept get(Integer id);
}
