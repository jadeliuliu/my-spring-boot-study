package com.liuxuan.service;

import com.liuxuan.StartApplication;
import com.liuxuan.repository.domain.Student;
import com.liuxuan.repository.mapper.StudentMapper;
import com.liuxuan.repository.mapper.StudentXmlMapper;
import com.liuxuan.repository.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: com.liuxuan
 * @date: 2022-12-25 17:58
 **/
@SpringBootTest(classes = StartApplication.class)
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentXmlMapper studentXmlMapper;

    @Test
    public void testFindAll() {
        List<Student> studentList = studentMapper.findAll();
        System.out.println(studentList);
    }

    @Test
    public void testFind() {
        List<Student> studentList = studentXmlMapper.findAll();
        System.out.println(studentList);
    }
}
