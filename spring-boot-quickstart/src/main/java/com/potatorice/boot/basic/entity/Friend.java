package com.potatorice.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/9 11:34 上午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Friend {
    private String hobby;
    private String gender;

}
