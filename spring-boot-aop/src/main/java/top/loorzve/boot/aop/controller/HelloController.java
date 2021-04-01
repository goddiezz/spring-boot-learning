package top.loorzve.boot.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;
import top.loorzve.boot.aop.annotation.ControllerWebLog;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/4/1 2:48 下午
 */
@Slf4j
@RestController
@RequestMapping(value = "api")
public class HelloController {

    @GetMapping("hello")
    @ControllerWebLog(name = "getHello", isSaved = true)
    public String hello(String name, String title) {
        log.info("controller的name参数" + name);
        log.info("controller的title参数" + title);
        //休眠，模拟接口耗时
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int a = 5 / 0;
        return "hello";
    }
}
