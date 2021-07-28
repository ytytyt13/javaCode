package com.qunar.spring入门.pojo;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yang
 * 2021年02月19日 14:37:00
 */
public class  ReplaceDog implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("Hello, I am a white dog...");
        Arrays.stream(args).forEach(str -> System.out.println("参数:" + str));
        return obj;
    }
}

