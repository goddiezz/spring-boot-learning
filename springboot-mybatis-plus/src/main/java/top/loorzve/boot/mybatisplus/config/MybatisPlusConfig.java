package top.loorzve.boot.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :Flobby
 * @version :1.0
 * @date :2021/3/31
 * @description :
 */

@Configuration
@MapperScan(basePackages = {"top.loorzve.boot.mybatisplus.mapper"})
public class MybatisPlusConfig {
    /**
     * 新的分⻚插件,⼀缓和⼆缓遵循mybatis的规则,需要设置
     * MybatisConfiguration#useDeprecatedExecutor = false 避免缓存
     * 出现问题(该属性会在旧插件移除后⼀同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new
                MybatisPlusInterceptor();
        //向Mybatis过滤器链中添加分⻚拦截器
        interceptor.addInnerInterceptor(new
                PaginationInnerInterceptor(DbType.MYSQL));
        //还可以添加i他的拦截器
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer
    configurationCustomizer() {
        return configuration ->
                configuration.setUseDeprecatedExecutor(false);
    }
}
