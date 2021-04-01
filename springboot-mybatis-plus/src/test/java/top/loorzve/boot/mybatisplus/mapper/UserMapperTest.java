package top.loorzve.boot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.loorzve.boot.mybatisplus.entity.User;

import javax.annotation.Resource;

import java.io.Serializable;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void insert() {
        User user = User.builder()
                .name("Rose")
                .age(19)
                .email("rose@baomidou.com")
                .build();
        int row = userMapper.insert(user);
        assertEquals(1, row);

        System.out.println("雪花算法id: " + user.getId());
    }

    @Test
    void deleteById() {
        int rows = userMapper.deleteById(1);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","jack");
        map.put("age",20);
        int rows = userMapper.deleteByMap(map);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    void selectById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void selectBatchIds() {
        List<Long> ids = Arrays.asList(
                1L,
                2L
        );
        List<User> list = userMapper.selectBatchIds(ids);
        list.forEach(System.out::println);
    }

    @Test
    void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","Jone");

        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    @Test
    void selectList() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.select("name","age")
                .in("age",Arrays.asList(1,2))
                .last("limit 2");

        List<User> list = userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    @Test
    void selectMaps() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.like("name","J%")
                .lt("age",30)
                .select("name","age");

        List<Map<String, Object>> maps = userMapper.selectMaps(query);
        maps.forEach(System.out::println);
    }

    @Test
    void updateById() {
        User user = new User();
        user.setAge(18);
        user.setEmail("1286@qq.com");
        int rows = userMapper.updateById(user);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    void update() {
        UpdateWrapper<User> update = new UpdateWrapper<>();
        update.eq("name","Rose").eq("age",19);
        User user = new User();
        user.setAge(20);
        user.setEmail("12862@qq.com");
        int rows = userMapper.update(user,update);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void testCustomSQL() {
        String name="Jack";
        String email="";
        List<User>list=userMapper.findUser(name,email);
        list.forEach(System.out::println);
    }

    @Test
    public void testCustomSQL2() {
        LambdaQueryWrapper<User> query=new LambdaQueryWrapper<>();
        query.eq(User::getName, "Jack");
        List<User>list=userMapper.selectAll((java.sql.Wrapper) query);
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectByPage() {
        LambdaQueryWrapper<User>query=new
                LambdaQueryWrapper<>();
        query.ge(User::getAge, 10)
                .
                        orderByDesc(User::getAge);
        Page<User> page=new Page<>(1, 5);
        userMapper.selectPage(page, query);
        System.out.println("总⻚数："+page.getPages());
        System.out.println("总记录数："+page.getTotal());
        List<User>list=page.getRecords();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectByPage1() {
        LambdaQueryWrapper<User>query=new
                LambdaQueryWrapper<>();
        query.ge(User::getAge, 10)
                .
                        orderByDesc(User::getAge);
        Page<User>page=new Page<>(1, 5, false);
        userMapper.selectPage(page, query);
        System.out.println("总⻚数："+page.getPages());
        System.out.println("总记录数："+page.getTotal());
        List<User>list=page.getRecords();
        list.forEach(System.out::println);
    }
}