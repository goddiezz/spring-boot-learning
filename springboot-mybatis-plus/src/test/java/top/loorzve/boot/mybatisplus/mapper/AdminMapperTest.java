package top.loorzve.boot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.loorzve.boot.mybatisplus.domain.Admin;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AdminMapperTest {
    @Resource
    private AdminMapper adminMapper;

    @Test
    public void testInsert() {
        Admin admin = Admin.builder()
                .name("张三")
                .age(20)
                .email("zhangsan@qq.com")
                .build();
        int row = adminMapper.insert(admin);
        assertEquals(1, row);
    }

    @Test
    void testDelete() {
        int row = adminMapper.deleteById(1379107397418663938L);
        assertEquals(1, row);
    }

    @Test
    void testSelectList() {
    }
}