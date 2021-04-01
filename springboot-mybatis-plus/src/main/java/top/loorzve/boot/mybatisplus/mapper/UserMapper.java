package top.loorzve.boot.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.loorzve.boot.mybatisplus.entity.User;

import java.sql.Wrapper;
import java.util.List;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/30 9:00 上午
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> findUser(@Param("name")String name, @Param("email")String email);

    @Select("select * from `user` ${ew.customSqlSegment}")
    List<User>selectAll(@Param(Constants.WRAPPER) Wrapper wrapper);

//    List<User>selectAll(@Param(Constants.WRAPPER) Wrapper wrapper);
}
