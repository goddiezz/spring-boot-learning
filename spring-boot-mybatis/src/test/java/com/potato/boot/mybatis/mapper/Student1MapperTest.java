package com.potato.boot.mybatis.mapper;

import com.potato.boot.mybatis.domain.Student1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class Student1MapperTest {
    @Resource
    private Student1Mapper student1Mapper;

    @Test
    void getStudentManyToOne() {
        Student1 student = student1Mapper.getStudent(1001);
        System.out.println(student);
        assertEquals(1001, student.getStudentId());
        assertEquals("金晨星", student.getStudentName());
        assertEquals(1, student.getClazz().getClazzId());
        assertEquals("软件1921",student.getClazz().getClazzName());
        assertEquals(2,student.getCourses().size());
    }
}