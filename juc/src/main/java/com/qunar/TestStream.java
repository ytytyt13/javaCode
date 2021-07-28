package com.qunar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月15日 16:31:00
 */
public class TestStream {
    public static void main(String[] args) {
        Book b1 = new Book().setId(1).setName("a").setPrice("1");
        Book b2 = new Book().setId(2).setName("b").setPrice("2");
        Book b3 = new Book().setId(3).setName("c").setPrice("3");
        Book b4 = new Book().setId(4).setName("d").setPrice("4");
        Book b5 = new Book().setId(5).setName("e").setPrice("5");

        List<Book> books = Arrays.asList(b1, b2, b3, b4, b5);

        books.stream().filter((b)->{ return b.getId()%2==0;})
                .filter(b->{return Integer.valueOf(b.getPrice()) >= 3;})
                .forEach(System.out::println);


        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> collect = integers.stream().map(x -> { return x * 2; }).collect(Collectors.toList());

        //stream的生成
        List<Integer> int1 = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream();

        int[] int2 = {1,2,3,4,5,5,5,3,2,1};
        Arrays.stream(int2).distinct().forEach(System.out::println);

        Stream.of(int1);




//函数型接口
//        Function<String, Integer> function = new Function<String, Integer>() {
//
//            @Override
//            public Integer apply(String s) {
//                System.out.println(s);
//                return 1204;
//            }
//        };
        Function<String, Integer> function = s->{return s.length();};
        System.out.println(function.apply("hello"));

//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.length() == 5;
//            }
//        };
        Predicate<String> predicate = (s)->{return s.length() == 5;};
        System.out.println(predicate.test("aaaaa"));


//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        Consumer<String> consumer = (s)->{
            System.out.println(s);
        };
        consumer.accept("ssss");

//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "get";
//            }
//        };
//
        Supplier<String> stringSupplier = ()-> {return "ssss";};
        System.out.println(stringSupplier.get());


    }

}

@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
class Book {
    private int id;
    private String name;
    private String price;
}
