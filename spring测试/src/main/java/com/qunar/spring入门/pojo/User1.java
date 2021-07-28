package com.qunar.spring入门.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yang
 * 2020年12月29日 14:53:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User1 {
    private Integer userId=1;
    private String name="张三";
    private String password="123456";
}
