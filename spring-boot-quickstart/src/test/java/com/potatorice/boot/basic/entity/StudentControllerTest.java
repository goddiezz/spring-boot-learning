package com.potatorice.boot.basic.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
//@runwith(springrunner.class) junit4的写法
@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentControllerTest {
    //注入Spring上下文环境
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    public void testLoadService() {
        //测试Spring上下文环境中是否有testBeanService这样一个bean，有的话表示xml配置文件生效
        boolean flag = ioc.containsBean("student");
        assertTrue(flag);
        Student expectedStudent = Student.builder().id(123).name("tom").build();
        Student student = (Student) ioc.getBean("student");
        assertEquals(expectedStudent, student);
    }

}