package top.loorzve.boot.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.loorzve.boot.aop.annotation.ControllerWebLog;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PotatoRice
 * @description：自定义切面
 * @date 2021/4/1 2:31 下午
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class ControllerWebLogAspect {

    private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(public * top.loorzve.boot.aop.controller..*.*(..))")
    public void weblog() {

    }

    /**
     * 前置增强
     *
     * @param joinPoint        切点
     * @param controllerWebLog 日志对象
     */
    @Before(value = "weblog() && @annotation(controllerWebLog)")
    public void doBefore(JoinPoint joinPoint, ControllerWebLog controllerWebLog) {
        //从请求上下文中取得request的属性集合
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        //向下转型
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
//        log.info("请求的uri：" + request.getRequestURI());
//        log.info("请求的方法：" + request.getMethod());
//        log.info("请求的地址：" + request.getRemoteAddr());
//        log.info("请求的User-Agent：" + request.getHeader("User-Agent"));
        log.info("执行了方法：" + controllerWebLog.name());
        //自定义注解中需要保存日志
        if (controllerWebLog.isSaved()) {
            //取得接口请求参数
            Object[] args = joinPoint.getArgs();
            log.info("参数数组" + Arrays.toString(args));
            //保存到threadLocal中
            Map<String, Object> map = new HashMap<>(8);
            map.put("uri", request.getRequestURI());
            map.put("name", args[0]);
            map.put("title", args[1]);
            threadLocal.set(map);
            log.info("日志数据已保存。。。");

        } else {
            log.info("访问成功，日志不需要保存");
        }


    }

    @AfterReturning(value = " weblog() && @annotation(controllerWebLog)", returning = "res")
    public void doAfterReturning(ControllerWebLog controllerWebLog, Object res) {
        Map<String, Object> result = threadLocal.get();
        log.info("日志数量是：" + result);
    }

    @AfterThrowing(value = "weblog()",throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        RequestAttributes ra  =RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra !=null;
        HttpServletRequest request = sra.getRequest();
        //异常信息
        log.error("{}接口调用异常，异常信息{}",request.getRequestURI(),throwable.getMessage());
    }

    @Around(value = "weblog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //得到开始时间
        long startTime = System.currentTimeMillis();
        //执行连接点的目标方法getHello()
        Object ob = proceedingJoinPoint.proceed();
        System.out.println(ob);
        //计算出方法的真实执行时间，可以在目标方法加入线程休眠体会
        long takeTime = System.currentTimeMillis() - startTime;
        log.info("耗时：" + takeTime);
        return ob;
    }
}
