package top.loorzve.boot.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author flobby
 * @since 2021-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_student")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableId(value = "student_id", type = IdType.AUTO)
    private Integer studentId;

    /**
     * 学生所属班级的id
     */
    private Integer clazzId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生籍贯
     */
    private String hometown;

    /**
     * 出生日期
     */
    private LocalDate birthday;


    @Override
    protected Serializable pkVal() {
        return this.studentId;
    }

}
