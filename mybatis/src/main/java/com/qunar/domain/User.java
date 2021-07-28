package com.qunar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yang
 * 2020年12月29日 14:53:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Float salary;

    private Account account;
    private List<Account> accountList;

    public User(String name, Integer age, Float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
