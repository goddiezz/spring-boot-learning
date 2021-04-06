package top.loorzve.boot.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Flobby
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Model<Admin> {
    /**
    * 主键
ID
    */
    private Long id;

    /**
    * 姓名
    */
    private String name;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 逻辑
删除标记
    */
    @TableLogic
    private Byte deleted;
}