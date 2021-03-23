package com.potatorice.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
public class Mother {
    private String name;
    private List<String> alias;
}
