package com.qunar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


enum Color{
    Red,GREEN,BLUE;
}

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月11日 19:56:00
 */
public class LambdaTest {
    public static void main(String[] args) {

        LambdaMethod l=(x, y)->{return x+y;};
        new lambdaMethod2((x, y)->{return x+y;});

        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
        players.forEach((player)->{
            System.out.println("a");
            System.out.println(player);
        });



        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(atp, new Comparator<String>() {
            @Override
            public int compare(String  o1, String o2) {
                return 0;
            }
        });

        Arrays.sort(atp, (String s1, String s2) -> { return s2.compareTo(s1); });

        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(atp, sortByName);

//        ArrayList<Integer> num = new ArrayList<>();
//        num.add(1);
//        num.add(2);
//        num.add(3);
        Integer[] num={1,2,3};

        Arrays.sort(num,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });


    }



    private static void run() {
        System.out.println("aaa");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("bbb");
            }
        });

        new Thread(()->{
            System.out.println("aaaa");
        });
    }
}

