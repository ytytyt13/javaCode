package com.qunar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yang
 * 2021年01月27日 18:25:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliasUser {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private Float userSalary;
}
