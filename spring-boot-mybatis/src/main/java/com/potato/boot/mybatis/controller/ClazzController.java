package com.potato.boot.mybatis.controller;

import com.potato.boot.mybatis.controller.dto.AjaxResponse;
import com.potato.boot.mybatis.mapper.ClazzMapper;
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
 * @date 2021/3/25 6:47 下午
 */
@RestController
@RequestMapping(value = "/api/v1/clazz")
@Slf4j
@Validated
public class ClazzController {

    @Resource
    private ClazzMapper clazzMapper;


    @ApiOperation("路径传参")
    @GetMapping("{id}")
    public AjaxResponse getClazz(@PathVariable("id") int id) {
        return AjaxResponse.success(clazzMapper.getClazz(id));
    }

}