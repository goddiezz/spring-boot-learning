package com.potatorice.boot.basic.dao;

import com.potatorice.boot.basic.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/16 9:22 上午
 */
@Repository
public class StudentDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加一位同学
     *
     * @param student
     * @return Student
     */
    public Student save(Student student) {
        String sql = "INSERT INTO t_student (name,github_name,nickname,hometown,birthday,constellation,mobile,qq,email,avatar,github,hobby,signature,color) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        Object[] args = {student.getName(), student.getGithub_name(), student.getNickname(), student.getHometown(), student.getBirthday(), student.getConstellation(), student.getMobile(), student.getQq(), student.getEmail(), student.getAvatar(), student.getGithub(), student.getHobby(), student.getSignature(), student.getColor()};
        int count = jdbcTemplate.update(sql, args);
        if (count == 1) {
            return student;
        } else {
            return null;
        }
    }

    /**
     * 按id删除一位同学
     *
     * @param student
     * @return
     */
    public int deleteById(Student student) {
        return jdbcTemplate.update("UPDATE t_student SET deleted = 1 WHERE id = ?",
                student.getId());
    }

    /**
     * 修改一位同学的信息
     *
     * @param student
     * @return int
     */
    public int update(Student student) {
        return jdbcTemplate.update("UPDATE t_student SET name = ?,github_name = ?,nickname = ?,hometown = ?,birthday = ?,constellation = ?,mobile = ?,qq = ?,email = ?,avatar = ?,github = ?,hobby = ?,signature = ?,color = ?,update_time = ? WHERE id = ?",
                student.getName(),
                student.getGithub_name(),
                student.getNickname(),
                student.getHometown(),
                student.getBirthday(),
                student.getConstellation(),
                student.getMobile(),
                student.getQq(),
                student.getEmail(),
                student.getAvatar(),
                student.getGithub(),
                student.getHobby(),
                student.getSignature(),
                student.getColor(),
                new Date(),
                student.getId());
    }

    /**
     * 按id查询一位同学
     *
     * @param id
     * @return student
     */
    public Student findById(Integer id) {
        List<Student> student = jdbcTemplate.query("SELECT * FROM t_student WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
        return student.get(0);
    }

    /**
     * @return List<Student>
     */
    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM t_student", new BeanPropertyRowMapper<>(Student.class));
    }
}
