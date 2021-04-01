package top.loorzve.boot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.loorzve.boot.mybatisplus.entity.User;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author loorzve
 * @description
 * @date 2021-03-31 16:47
 */


@SpringBootTest
@ExtendWith(SpringExtension.class)
class BaseMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void selectOne() {
    }

    @Test
    void selectCount() {
    }

    @Test
    void selectList() {
        String name = "Jack"; //name不为空
        String email = ""; //email为空串
        QueryWrapper<User> query = new QueryWrapper<>();
        query.like(StringUtils.isNotEmpty(name), "name", name)
                //因为email为空串，该条件未⽣效
                .like(StringUtils.isNotEmpty(email), "email", email);

        List<User> list = userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    @Test
    void selectList1() {
        QueryWrapper<User>query=new QueryWrapper<>();
        Map<String, Object> params=new HashMap<>();
        params.put("name", "Jack");
        params.put("age", 18);
        params.put("email", null);
        query.allEq((k, v) ->!k.equals("name"), params, false);
        List<User>list=userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    @Test
    void selectList2() {
        LambdaQueryWrapper<User> lambdaQ= Wrappers.lambdaQuery();
        lambdaQ.like(User::getName, "Jack")
                .lt(User::getAge, 18);
        List<User> list = userMapper.selectList(lambdaQ);
        list.forEach(System.out::println);
    }

    @Test
    void selectList3() {
        List<User>list=new LambdaQueryChainWrapper<User>
                (userMapper)
                        .likeRight(User::getName, "Jack")
                        .and(q->q.lt(User::getAge, 40)
                                .or()
                                .isNotNull(User::getEmail))
                        .list();
        list.forEach(System.out::println);
    }

    @Test
    void selectMaps() {
    }

    @Test
    void selectObjs() {
    }

    @Test
    void selectPage() {
    }

    @Test
    void selectMapsPage() {
    }
}
