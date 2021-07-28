package com.qunar.spring入门;


import com.qunar.spring入门.pojo.Taxi;
import com.qunar.spring入门.pojo.User;
import com.qunar.spring入门.pojo.User1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yang
 * 2021年02月19日 20:00:00
 */
public class 引入多个配置文件 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("配置文件1.xml");

        applicationContext.setAllowBeanDefinitionOverriding(false);
        applicationContext.refresh();


        User1 car1 = (User1) applicationContext.getBean("user");
        System.out.println(car1);

    }
}
