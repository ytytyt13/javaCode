package com.qunar;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月15日 21:30:00
 */
public class TestCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<Void> saync = CompletableFuture.runAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("saync");
        });

        try {
            System.out.println("ccccc");
            saync.get();
            System.out.println("bbbbb");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("_________________________");
        CompletableFuture<Integer> aaaa = CompletableFuture.supplyAsync(() -> {
            System.out.println("aaaa");
            return 100;
        });
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("aaaaaaaaaaaa");
        try {
            System.out.println(aaaa.whenComplete((u, t) -> {
                System.out.println(u);
                System.out.println(t);
            }).exceptionally(f -> {
                System.out.println(f);
                return 300;
            }).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
