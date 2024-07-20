package com.ghrlearn.tlias.mapper;

import com.ghrlearn.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //获取当前页的结果列表
    /*较新版本的mybatis为保证兼容性，在函数的形参需要使用@Param来手动构建映射*/
    public List<Emp> list(@Param("name") String name, @Param("gender") Short gender,
                          @Param("begin") LocalDate begin, @Param("end") LocalDate end);


    void delete(@Param("ids") List<Integer> ids);

    //新增员工
    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from emp where username=#{username} and password =#{password}")
    public Emp getByUsernameAndPassword(Emp emp);
}
