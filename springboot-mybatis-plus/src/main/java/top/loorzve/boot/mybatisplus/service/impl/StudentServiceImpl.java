package top.loorzve.boot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.loorzve.boot.mybatisplus.domain.Student;
import top.loorzve.boot.mybatisplus.mapper.StudentMapper;
import top.loorzve.boot.mybatisplus.service.StudentService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author flobby
 * @since 2021-04-02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
