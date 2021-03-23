package com.potato.boot.mybatis.mapper;

import com.potato.boot.mybatis.domain.Teacher1;

public interface Teacher1Mapper {
    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher1 record);

    int insertSelective(Teacher1 record);

    Teacher1 selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher1 record);

    int updateByPrimaryKey(Teacher1 record);
}