package com.potato.boot.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    /**
    * 班级id
    */
    private Integer clazzId;

    /**
    * 班级名称
    */
    private String clazzName;

    /**
    * 班级管理老师的id
    */
    @JsonIgnore
    private Integer teacherId;
 
    /**
     * 一方里声明多方的集合
     */
    @JsonIgnore
    private List<Student1> students;

    /**
     * 管理班级的教师对象（一对一）
     */
    @JsonIgnore
    private Teacher1 teacher;
}