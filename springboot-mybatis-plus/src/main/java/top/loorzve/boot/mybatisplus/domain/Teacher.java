package top.loorzve.boot.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("t_teacher")
public class Teacher extends Model<Teacher> {

    private static final long serialVersionUID = 1L;

    /**
     * 教师id
     */
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师管理班级id
     */
    private Integer clazzId;


    @Override
    protected Serializable pkVal() {
        return this.teacherId;
    }

}
