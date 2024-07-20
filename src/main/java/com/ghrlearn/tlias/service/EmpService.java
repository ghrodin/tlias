package com.ghrlearn.tlias.service;


import com.ghrlearn.tlias.pojo.Emp;
import com.ghrlearn.tlias.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    void save(Emp emp);
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
    void delete(List<Integer> ids);
    Emp get(Integer id);
    void update(Emp emp);

    public Emp login(Emp emp);
}
