package com.qunar.spring入门;

import com.qunar.spring入门.pojo.Car;
import com.qunar.spring入门.pojo.User2;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author yang
 * 2021年02月20日 11:51:00
 */
public class bean的继承 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean的继承.xml");
        User2 user = (User2)applicationContext.getBean("user2");
        System.out.println(user);
    }
}
