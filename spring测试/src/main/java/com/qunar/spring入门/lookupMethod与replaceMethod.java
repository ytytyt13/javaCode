package com.qunar.spring入门;

import com.qunar.spring入门.pojo.Car;
import com.qunar.spring入门.pojo.OriginalDog;
import com.qunar.spring入门.pojo.Taxi;
import com.qunar.spring入门.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang
 * 2021年02月19日 14:07:00
 */
public class lookupMethod与replaceMethod {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("lookupMethodAndRelapceMethod.xml");

        Car car1 = (Car) applicationContext.getBean("car");
        Car car2 = (Car) applicationContext.getBean("car");
        System.out.println("Car:singleton,所以car1==car2应该为" + (car1 == car2));

        Taxi taxi1 = car1.getTaxi();
        Taxi taxi2 = car1.getTaxi();
        System.out.println("Taxi:prototype,Car:singleton,未使用lookup-method注入所以taix1==taxi2应该为" + (taxi1 == taxi2));

        Taxi taxi3 = car1.createTaxi();
        Taxi taxi4 = car1.createTaxi();
        System.out.println("Taxi:prototype,Car:singleton,使用lookup-method注入所以taix3==taxi4应该为" + (taxi3 == taxi4));

        taxi1.say();
        taxi3.say();

        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        OriginalDog originalDog = (OriginalDog) applicationContext.getBean("originalDog");
        originalDog.sayHello("sssss");

    }
}
