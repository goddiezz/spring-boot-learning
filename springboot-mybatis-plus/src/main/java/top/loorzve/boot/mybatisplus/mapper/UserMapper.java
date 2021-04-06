package top.loorzve.boot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.loorzve.boot.mybatisplus.domain.User;

import java.util.List;

/**
 * @author Flobby
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 自定义SQL语句查询
     *
     * @param name 姓名
     * @param email 邮箱
     * @return 用户列表
     */
    List<User> findUser(@Param("name") String name,
                        @Param("email") String email);

    /**
     * 自定义接口使用条件构造器（注解方式）
     *
     * @param wrapper 条件
     * @return 用户列表
     */
    @Select("select * from `user` ${ew.customSqlSegment}")
    List<User> selectAllByAnnotations(@Param(Constants.WRAPPER) Wrapper wrapper);

    /**
     * 自定义接口使用条件构造器（xml实现）
     *
     * @param wrapper 条件
     * @return 用户列表
     */
    List<User> selectAllByXml(@Param(Constants.WRAPPER)Wrapper wrapper);
}