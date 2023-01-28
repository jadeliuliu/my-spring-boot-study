package com.liuxuan.repository.mapper;

import com.liuxuan.repository.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liuxuan
 * @date: 2022-12-25 17:57
 **/
@Mapper
@Repository
public interface StudentMapper {

    @Select("select * from student")
    public List<Student> findAll();
}
