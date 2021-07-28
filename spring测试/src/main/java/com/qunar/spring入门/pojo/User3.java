package com.qunar.spring入门.pojo;

/**
 * @author yang
 * 2021年02月20日 12:11:00
 */
public class User3 {

    private int id;

    private String name;

    private String beanName;

    public User3(){
        System.out.println("User 被实例化");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("设置："+name);
        this.name = name;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
    /**
     * 自定义的初始化方法
     */
    public void start(){
        System.out.println("User 中自定义的初始化方法");
    }

    @Override
    public String toString() {
        return "User3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }
}
