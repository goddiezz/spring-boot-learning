package com.potatorice.boot.basic.controller;

import com.potatorice.boot.basic.controller.dto.AjaxResponse;
import com.potatorice.boot.basic.entity.Student;
import com.potatorice.boot.basic.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/16 8:16 下午
 */
@RestController
@RequestMapping(value = "/api/v1/student")
@Slf4j
@Validated
//@Transactional
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("all")
    public AjaxResponse getStudent() {
        List<Student> studentList = studentService.getAll();
        return AjaxResponse.success(studentList);
    }

    @GetMapping("{id}")
    public AjaxResponse getStudentById(@PathVariable("id") int id) {

        return AjaxResponse.success(studentService.getById(id));

    }

    @DeleteMapping()
    public AjaxResponse deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
        return AjaxResponse.success();
    }

    @PutMapping()
    public AjaxResponse updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
//        int a = 13/0;
        return AjaxResponse.success(student);
    }


    @PostMapping("body")
    public AjaxResponse saveStudent(@RequestBody Student student) {
        boolean flag = studentService.postStudent(student);
        return AjaxResponse.success(student);
    }

    @GetMapping()
    public AjaxResponse getStudentByParam(@RequestParam("id") int id) {
        return AjaxResponse.success(studentService.getById(id));
    }
}
