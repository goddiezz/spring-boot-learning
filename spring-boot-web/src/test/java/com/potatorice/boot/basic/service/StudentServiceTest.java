package com.potatorice.boot.basic.service;

import com.potatorice.boot.basic.dao.StudentDAO;
import com.potatorice.boot.basic.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudentServiceTest {
    @Resource
    private StudentDAO studentDAO;

    @Test
    void getAll() {
        List<Student> studentList = studentDAO.findAll();
        log.info(String.valueOf(studentList));
    }
}