package com.qunar.spring入门.pojo;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author yang
 * 2021年02月19日 21:50:00
 */
public class MyCarFactoryBean implements FactoryBean<Taxi> {
    private String make;
    private int year ;

    public void setMake(String m){ this.make =m ; }

    public void setYear(int y){ this.year = y; }

    @Override
    public Taxi getObject(){
        //模拟复杂bean的构建过程
        Taxi taxi = new Taxi();
        taxi.setTaxiNmae("factory");
        return taxi;
    }

    @Override
    public Class<Car> getObjectType() { return Car.class ; }

    @Override
    public boolean isSingleton() { return false; }
}

