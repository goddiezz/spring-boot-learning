package com.potatorice.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/9 11:37 上午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Child {
    private String name;
    private Integer age;
    private List<Friend> friends;
}
