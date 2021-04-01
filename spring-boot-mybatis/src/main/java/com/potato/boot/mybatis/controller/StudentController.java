package com.potato.boot.mybatis.controller;

import com.potato.boot.mybatis.controller.dto.AjaxResponse;
import com.potato.boot.mybatis.mapper.Student1Mapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/25 6:50 下午
 */
@RestController
@RequestMapping(value = "/api/v1/student")
@Slf4j
@Validated
public class StudentController {

    @Resource
    private Student1Mapper studentMapper;


    @ApiOperation("路径传参")
    @GetMapping("{id}")
    public AjaxResponse getClazz(@PathVariable("id") int id) {
        return AjaxResponse.success(studentMapper.getStudent(id));
    }
}