package com.potatorice.boot.basic.entity;

import com.potatorice.boot.basic.conf.MixPropertySourceFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/9 11:32 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@PropertySource(value = {"classpath:family.properties"}, factory = MixPropertySourceFactory.class)
//@PropertySource(value = {"classpath:family.yml"}, factory = MixPropertySourceFactory.class)
@ConfigurationProperties(prefix = "family")
//@Validated
public class Family {
//    @Length(min = 5 , max = 20 , message = "名称应为5到20位")
    private String familyName;
    @Resource
    private Father father;
    @Resource
    private Mother mother;
    @Resource
    private Child child;
}