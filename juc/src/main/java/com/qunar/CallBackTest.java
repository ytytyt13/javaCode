package com.qunar;

import java.util.Arrays;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月17日 20:30:00
 */
public class CallBackTest {
    public static void main(String[] args) {
        new Father(new Children[]{new Son(),new Sister()}).eat();
    }
}

interface Children {

    public void fatherEat();
}

class Son implements Children {

    private void eat() {
        System.out.println("son eatting");
    }

    @Override
    public void fatherEat() {
        eat();
    }
}


class Sister implements Children {

    private void eat() {
        System.out.println("sister eatting");
    }

    @Override
    public void fatherEat() {
        eat();
    }
}

class Father {
    private Children[] childrens;

    public Father(Children[] childrens){
        this.childrens = childrens;
    }

    public void eat() {
        System.out.println("father eatting");
        Arrays.stream(childrens).forEach(children -> children.fatherEat());
    }
}

