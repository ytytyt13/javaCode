package com.qunar.spring入门.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author yang
 * 2021年02月20日 11:18:00
 */
@Data
@AllArgsConstructor
@Component
public class User2 implements InitializingBean{
    private Integer userId;
    private String name;
    private String password;

    public User2(){
        System.out.println("构造器");
    }


    @Bean(initMethod = "prinfInfo")
    public User foo() {

        System.out.println("bean");
        return new User();
    }

    @PostConstruct
    void printInfo() {
        System.out.println("user2");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after");
    }
}
