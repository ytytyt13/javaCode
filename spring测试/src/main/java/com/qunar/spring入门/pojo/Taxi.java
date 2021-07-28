package com.qunar.spring入门.pojo;

/**
 * @author yang
 * 2021年02月19日 14:08:00
 */
public class Taxi {

    private String taxiNmae;

    public void setTaxiNmae(String taxiNmae) {
        this.taxiNmae = taxiNmae;
    }

    public void say() {
        System.out.println("I am a Taxi..."+taxiNmae);
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiNmae='" + taxiNmae + '\'' +
                '}';
    }
}
