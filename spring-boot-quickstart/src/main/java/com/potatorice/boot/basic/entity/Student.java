package com.potatorice.boot.basic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author PotatoRice
 * @description：Ioc
 * @date 2021/3/11 4:05 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@entity
public class Student {
    private int id;
    private String name;
    private String github_name;
    private String nickname;
    private String hometown;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String constellation;
    private String mobile;
    private String qq;
    private String email;
    private String avatar;
    private String github;
    private String hobby;
    private String signature;
    private String color;
    private Date createTime;
    private Date updateTime;
    private int deleted;
}
