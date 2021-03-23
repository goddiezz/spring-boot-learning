package com.potatorice.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

//import javax.persistence.Entity;


/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/9 11:36 上午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
//@Entity
public class Father {

    private String name;
    private Integer age;
}
