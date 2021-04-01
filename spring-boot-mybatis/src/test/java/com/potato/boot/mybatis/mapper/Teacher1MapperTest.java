package com.potato.boot.mybatis.mapper;

import com.potato.boot.mybatis.domain.Teacher1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class Teacher1MapperTest {
    @Resource
    private Teacher1Mapper teacher1Mapper;

    @Test
    void getTeacherOneByOne() {
        Teacher1 teacher = teacher1Mapper.getTeacherOneByOne(1);
        System.out.println(teacher);
//        assertEquals("徐老师", teacher);
    }
}