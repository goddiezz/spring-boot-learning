package com.potatorice.boot.basic.impl;

import com.potatorice.boot.basic.dao.StudentDAO;
import com.potatorice.boot.basic.entity.Student;
import com.potatorice.boot.basic.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/16 8:22 下午
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDAO studentDAO;

    @Override
    public boolean postStudent(Student student) {
        Student saveStudent = studentDAO.save(student);
//        int a = 13/0;
        return saveStudent != null;
    }

    @Override
    public boolean deleteStudent(Student student) {
        int row = studentDAO.deleteById(student);
        return row != 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        int row = studentDAO.update(student);
        return row != 0;
    }

    @Override
    public Student getById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDAO.findAll();
    }

}
