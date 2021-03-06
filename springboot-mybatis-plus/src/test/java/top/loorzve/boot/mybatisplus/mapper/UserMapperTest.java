package top.loorzve.boot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.loorzve.boot.mybatisplus.domain.User;

import javax.annotation.Resource;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void save() {
        User user = User.builder()
                .name("fffffff")
                .age(20)
                .email("fff@qq.com")
                .build();
        int rows = userMapper.insert(user);
        assertEquals(1, rows);
    }

    @Test
    void deleteById() {
        int rows = userMapper.deleteById(1376708510928080897L);
        assertEquals(1, rows);
    }

    @Test
    void selectById() {
        User user = userMapper.selectById(1376706211665215490L);
        log.info("###########" + user);
        assertEquals(1376706211665215490L, user.getId());
    }

    @Test
    void batchDelete() {
        List<Long> ids = new ArrayList<>();
        ids.add(1376701712674381825L);
        ids.add(1376703607883218945L);
        ids.add(1376703654687473665L);
        int rows = userMapper.deleteBatchIds(ids);
        assertEquals(3, rows);
    }

    @Test
    void update() {
        User user = User.builder()
                .id(1376706211665215490L)
                .name("update")
                .age(19)
                .email("update@qq.com")
                .build();
        int rows = userMapper.updateById(user);
        assertEquals(1, rows);
    }

    @Test
    void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        // map.put("name", "fff");
        map.put("age", 23);
        int rows = userMapper.deleteByMap(map);
        assertEquals(2, rows);
    }

    @Test
    void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "bbb");
        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);
        assertEquals(1, userList.size());
    }

    @Test
    void selectList() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.select("name", "age") //????????????????????????
                .in("age", Arrays.asList(18, 19, 20))
                .last("limit 2");
        List<User> list = userMapper.selectList(query);
        list.forEach(System.out::println);
        assertEquals(2, list.size());
    }

    @Test
    void selectMap() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.like("name", "J%") //like???MP???????????????????????????"????????????"
                .lt("age", 30) //lt???MP???????????????????????????"??????"??????
                .select("name", "age");
        List<Map<String, Object>> maps =
                userMapper.selectMaps(query);
        maps.forEach(System.out::println);
        assertEquals(2, maps.size());
    }

    @Test
    void updateEq() {
        UpdateWrapper<User> update = new UpdateWrapper<>();
        update.eq("name", "Jack").eq("age", 29); //eq???MP???????????????????????????"??????"??????
        User user = new User();
        user.setAge(27);
        user.setEmail("hadoopcn2@163.com");
        int rows = userMapper.update(user, update);
        System.out.println("??????????????????" + rows);
        assertEquals(1, rows);
    }

    @Test
    void selectLike() {
        String name = "Jack"; //name?????????
        String email = ""; //email?????????
        QueryWrapper<User> query = new QueryWrapper<>();
        query.like(StringUtils.isNotEmpty(name), "name", name)
                //??????email??????????????????????????????
                .like(StringUtils.isNotEmpty(email), "email", email);

        List<User> list = userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    @Test
    void selectAllEq() {
        //????????????
        QueryWrapper<User> query = new QueryWrapper<>();
        Map<String, Object> params = new HashMap<>();
        params.put("name", "Jack");
        params.put("age", 18);
        params.put("email", null);
// query.allEq(params,false);
        query.allEq((k, v) -> !k.equals("name"), params, false);
        List<User> list = userMapper.selectList(query);
        list.forEach(System.out::println);
        assertEquals(1, list.size());
    }

    @Test
    void selectLambda() {
         LambdaQueryWrapper<User> lambdaQ = new QueryWrapper<User>().lambda();
//         LambdaQueryWrapper<User> lambdaQ = new LambdaQueryWrapper<>();
//        LambdaQueryWrapper<User> lambdaQ = Wrappers.lambdaQuery();
//        lambdaQ.like(User::getName, "Jack")
//                .lt(User::getAge, 30);
//        List<User> list = userMapper.selectList(lambdaQ);
        List<User> list = new LambdaQueryChainWrapper<User>
                (userMapper)
                .likeRight(User::getName, "Jack")
                .and(q -> q.lt(User::getAge, 40)
                        .or()
                        .isNotNull(User::getEmail)
                )
                .list();

        list.forEach(System.out::println);
        assertEquals(1, list.size());
    }

    @Test
    public void testCustomSQL() {
        String name = "Jack"; //name?????????
        String email = ""; //email?????????
        List<User> list = userMapper.findUser(name,email);
        list.forEach(System.out::println);
        assertEquals(1, list.size());
    }

    @Test
    public void testCustomSQL2() {
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        query.eq(User::getName, "eee");
        // ????????????
        List<User> list = userMapper.selectAllByAnnotations(query);
        // xml??????
//        List<User> list = userMapper.selectAllByXml(query);
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectByPage() {
        LambdaQueryWrapper<User> query = new
                LambdaQueryWrapper<>();
        query.ge(User::getAge, 10) //???????????????????????????10
                .orderByDesc(User::getAge); //???????????????????????????
        Page<User> page = new Page<>(1, 5); //?????????1????????????5?????????
        userMapper.selectPage(page, query); //page???????????????query????????????
        System.out.println("????????????" + page.getPages());
        System.out.println("???????????????" + page.getTotal());
        // ???????????????????????????????????????????????????
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        assertEquals(5, list.size());
    }

    // Active Record??????
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("springboot");
        user.setAge(18);
        user.setEmail("springboot@163.com");
        boolean success = user.insert();
        assertEquals(true, success);
    }

    @Test
    public void testSelect() {
        User user = new User();
        List<User> users = user.selectAll();
        users.forEach(System.out::println);
        assertEquals(14,users.size());
    }

    @Test
    public void testUpdate() {
        User user = User.builder()
                .id(1283915378849751041L)
                .name("mbp")
                .age(30)
                .build();
        boolean success = user.insertOrUpdate();
        assertEquals(true, success);
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setId(1376714380133732353L);
        boolean success = user.deleteById();
        assertEquals(false, success);
    }
}