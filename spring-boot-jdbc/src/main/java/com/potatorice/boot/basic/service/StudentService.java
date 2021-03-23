package com.potatorice.boot.basic.service;

import com.potatorice.boot.basic.entity.Student;

import java.util.List;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/16 8:19 下午
 */
public interface StudentService {
    /**
     * 新增同学
     *
     * @param student
     * @return
     */
    boolean postStudent(Student student);

    /**
     *删除同学
     *
     * @param student
     * @return
     */
    boolean deleteStudent(Student student);

    /**
     * 修改同学信息
     *
     * @param student
     * @return
     */
    boolean updateStudent(Student student);

    /**
     *
     * @param id
     * @return
     */
    Student getById(int id);

    /**
     *
     * @return
     */
    List<Student> getAll();
}
