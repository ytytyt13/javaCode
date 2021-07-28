package com.qunar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yang
 * 2021年01月29日 12:56:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer accountId;
    private Integer userId;
    private Float userMoney;

    public Account(Integer userId, Float userMoney) {
        this.userId = userId;
        this.userMoney = userMoney;
    }
}
