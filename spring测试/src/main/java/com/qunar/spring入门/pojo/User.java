package com.qunar.spring入门.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author yang
 * 2020年12月29日 14:53:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;

    private String name;

    @Value("")
    private String password;

    @Autowired
    private Taxi taxi;

    private void prinfInfo() {
        System.out.println("user");
    }
}
