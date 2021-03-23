package com.potatorice.boot.basic.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/5 7:31 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Param {
    private Integer id;
    private String title;
}