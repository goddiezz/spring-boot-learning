package com.potato.boot.mybatis.mapper;

import com.potato.boot.mybatis.domain.Student1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author loorzve
 */
public interface Student1Mapper {
    /**
     * 新增学生
     *
     * @param student1 student对象
     * @return int
     */
    int insert(Student1 student);

    /**
     * 根据id删除学生
     *
     * @param studentId 学生id
     * @return int
     */
    int deleteByPrimaryKey(Integer studentId);

    /**
     * 根据id查询学生
     *
     * @param studentId 学生id
     * @return 查询到的学生对象
     */
    Student1 selectByPrimaryKey(Integer studentId);


    /**
     * 修改学生信息
     *
     * @param student1 student对象
     * @return int
     */
    int updateByPrimaryKeySelective(Student1 student);

    /**
     * 批量新增学生
     *
     * @param students 学生集合
     * @return int
     */
    int batchInsert(@Param("students") List<Student1> students);

    /**
     * 批量删除
     *
     * @param idList 待删记录id集合
     * @return int
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * 批量修改
     *
     * @param students 学生集合
     * @return int
     */
    int batchUpdate(@Param("students") List<Student1> students);

    /**
     * 按条件单表查询，结合动态SQL
     *
     * @param student 参数对象
     * @return List<Student>
     */
    List<Student1> selectByDynamicSql(Student1 student);
}