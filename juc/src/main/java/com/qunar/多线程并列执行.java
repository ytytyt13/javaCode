package com.qunar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yang
 * 2021年03月23日 14:14:00
 */
public class 多线程并列执行 {
    public static void main(String[] args) {
        List<Callable<String>> taskList = new ArrayList<>();

        for (int i = 0; i <9; i++) {
            final int a = i;
            taskList.add(()->{
                return String.valueOf(a);
            });
        }

        ExecutorService executorService = Executors.newFixedThreadPool(9);


        try {
            List<Future<String>> futures = executorService.invokeAll(taskList);

            Future<String> stringFuture = futures.get(0);

            System.out.println(stringFuture.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        List<Map<String,Object>> lists = new ArrayList<>();

        for (int i = 0; i <20; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put(String.valueOf(i),i);
            map.put(String.valueOf(i)+"a",i+"a");
            lists.add(map);
        }

        System.out.println(lists);


    }
}
