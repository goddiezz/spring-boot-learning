package com.potato.boot.mybatis.mapper;

import com.potato.boot.mybatis.domain.Student1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author loorzve
 */
public interface Student1Mapper {
    /**
     * 根据学生id查询（关联查询出所属班级信息)
     * @param studentId 学生id
     * @return student对象
     */
    Student1 getStudent(int studentId);

}