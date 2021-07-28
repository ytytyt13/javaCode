import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yang
 * 2021年04月28日 20:49:00
 */
public class 流式编程 {
    public static void main(String[] args) {

        //筛选与切片
        //        filter：过滤流中的某些元素
        //        limit(n)：获取n个元素
        //        skip(n)：跳过n元素，配合limit(n)可实现分页
        //        distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素
        Stream<Integer> stream = Stream.of(6,4,5,7,3,9,8,10,1,2,14,14,15);

        //filter过滤函数
        Stream<Integer> stream1 = stream.filter(s -> s > 5);  // 6,7,9,8,10,14,14,15

        //distinct去重函数
        Stream<Integer> distinct = stream1.distinct();  //6,7,9,8,10,14,15

        //skip,limit分页函数
        Stream<Integer> skip = distinct.skip(3); //8,10,14,15
        Stream<Integer> limit = skip.limit(2);//8,10

        limit.forEach(System.out::println);


        //映射map    函数型接口Function
        //        map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        //        flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        List<String> list = Arrays.asList("a,b,c","1,2,3");
        Stream<String> stream2 = list.stream().map(a->a.replaceAll(",",""));
        stream2.forEach(System.out::println);


        Stream<String> stream4 = list.stream().flatMap(s->{
           String[] split = s.split(",");
            Stream<String> stream3 = Arrays.stream(split);
            return stream3;
        });
        stream4.forEach(System.out::println);

        //排序
        //        sorted()：自然排序，流中元素需实现Comparable接口
        //        sorted(Comparator com)：定制排序，自定义Comparator排序器
        List<String> list2 = Arrays.asList("aa", "ff", "dd");
        list2.stream().sorted().forEach(System.out::println);

        Student s1 = new Student("aa", 10);
        Student s2 = new Student("bb", 20);
        Student s3 = new Student("aa", 30);
        Student s4 = new Student("dd", 40);
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        studentList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getName().equals(o2.getName())) {
                        return o1.getAge() - o2.getAge();
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        ).forEach(System.out::println);


        //消费接口Consumer
        //peek：如同于map，能得到流中的每一个元素。但map接收的是一个Function表达式，有返回值；而peek接收的是Consumer表达式，没有返回值。
        studentList.stream().peek(s->s.setAge(100)).forEach(System.out::println);


        // 匹配、聚合操作
        //        allMatch：接收一个 Predicate 函数，当流中每个元素都符合该断言时才返回true，否则返回false
        //        noneMatch：接收一个 Predicate 函数，当流中每个元素都不符合该断言时才返回true，否则返回false
        //        anyMatch：接收一个 Predicate 函数，只要流中有一个元素满足该断言则返回true，否则返回false
        //        findFirst：返回流中第一个元素
        //        findAny：返回流中的任意元素
        //        count：返回流中元素的总个数
        //        max：返回流中元素最大值
        //        min：返回流中元素最小值

        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);

        boolean allMatch = list3.stream().allMatch(e -> e > 10); //false
        boolean noneMatch = list3.stream().noneMatch(e -> e > 10); //true
        boolean anyMatch = list3.stream().anyMatch(e -> e > 4);  //true

        Integer findFirst = list3.stream().findFirst().get(); //1
        Integer findAny = list3.stream().findAny().get(); //1

        long count = list3.stream().count(); //5
        Integer max = list3.stream().max(Integer::compareTo).get(); //5
        Integer min = list3.stream().min(Integer::compareTo).get(); //1


        System.out.println(studentList.stream().map(s -> s.getAge()).max(Integer::compareTo).get());


    }

    public static class Student{
        private String name;
        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
