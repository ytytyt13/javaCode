package com.qunar.事物.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yang
 * 2021年01月07日 16:46:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TxUser implements Serializable {

    private String name;
    private Integer age;
    private Float salary;

}
