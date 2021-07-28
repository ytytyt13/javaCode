package com.qunar.spring入门.pojo;

/**
 * @author yang
 * 2021年02月19日 14:08:00
 */
public class Car {

    //用于lookup-method注入
    public Taxi createTaxi(){
        System.out.println("car");
        Taxi taxi = new Taxi();
        taxi.setTaxiNmae("carCreate");
        return taxi;
    }

    private Taxi taxi;

    public Taxi getTaxi() {
        return taxi;
    }

    //setter注入
    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }
}
