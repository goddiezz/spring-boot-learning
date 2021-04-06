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
@TableName("t_clazz")
public class Clazz extends Model<Clazz> {

    private static final long serialVersionUID = 1L;

    /**
     * 班级id
     */
    @TableId(value = "clazz_id", type = IdType.AUTO)
    private Integer clazzId;

    /**
     * 班级名称
     */
    private String clazzName;

    /**
     * 管理班级教师id
     */
    private Integer teacherId;


    @Override
    protected Serializable pkVal() {
        return this.clazzId;
    }

}
