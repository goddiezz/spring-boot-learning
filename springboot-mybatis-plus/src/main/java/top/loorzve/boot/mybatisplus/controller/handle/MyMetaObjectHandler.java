package top.loorzve.boot.mybatisplus.controller.handle;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/4/6 12:33 上午
 */

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime",
                Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime",
                Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime",
                Date.class, new Date());
    }
}
