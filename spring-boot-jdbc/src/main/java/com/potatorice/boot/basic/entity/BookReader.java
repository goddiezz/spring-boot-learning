package com.potatorice.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PotatoRice
 * @date 2021/3/5 12:04 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookReader {
    private String name;
    private Integer age;

}
