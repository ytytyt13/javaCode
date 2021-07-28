package com.qunar;

import java.util.concurrent.RecursiveTask;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月15日 19:39:00
 */
public class TestForkJoin {
    public static void main(String[] args) {


    }


}

//    myTask m = new myTask(1,50);
//    myTask m1 = new myTask(51,100);
//    ForkJoinPool theadPool = new ForkJoinPool();
//    ForkJoinTask<Integer> submit = theadPool.submit(m);
//        try {
//                System.out.println(submit.get());
//                } catch (InterruptedException e) {
//                e.printStackTrace();
//                } catch (ExecutionException e) {
//                e.printStackTrace();
//                }
//                theadPool.shutdown();
//
//                System.out.println("############");
//                List<String> names = Arrays.asList("Bob", "Alice", "Tim");
//        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
//        System.out.println(persons);
//        System.out.println("############");

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "Person:" + this.name;
    }
}


class myTask extends RecursiveTask<Integer> {
    private final static int ADJUSR_VALUE = 10;
    private int begin;
    private int end;
    private int result;


    public myTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (end - begin <= ADJUSR_VALUE) {
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        } else {
            int middle = (end + begin) / 2;
            myTask myTask1 = new myTask(begin, middle);
            myTask myTask2 = new myTask(middle + 1, end);
            myTask1.fork();
            myTask2.fork();
            result = myTask1.join() + myTask2.join();
        }
        return result;
    }
}
