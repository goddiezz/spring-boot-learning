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
public class Course {
    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 选课学生（多对多）
     */
    @JsonIgnore
    private List<Student1> student1List;
}