package com.potato.boot.mybatis.mapper;

import com.potato.boot.mybatis.domain.Clazz;

public interface ClazzMapper {
    int deleteByPrimaryKey(Integer clazzId);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer clazzId);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);
}