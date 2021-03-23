package com.potato.boot.mybatis.mapper;

import com.potato.boot.mybatis.domain.CourseStudent;

public interface CourseStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseStudent record);

    int insertSelective(CourseStudent record);

    CourseStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseStudent record);

    int updateByPrimaryKey(CourseStudent record);
}