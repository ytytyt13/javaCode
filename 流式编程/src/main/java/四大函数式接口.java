import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author yang
 * 2021年04月28日 20:01:00
 */
public class 四大函数式接口 {
    public static void main(String[] args) {

//        Map<String, String[]> map = new HashMap<>();
//        String[] dd  =map.get("c");
//        int b = dd.length;


        //函数型接口,有输入有输出
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "APPLY";
            }
        };

        Function function1 = a->{return a+"APPLY2";};
        System.out.println(function.apply("消费型接口")+"----"+function1.apply("消费型接口2"));


        //供给型接口,无输入,有输出
        Supplier supplier = new Supplier<String>() {

            @Override
            public String get() {
                return "供给型接口";
            }
        };
        Supplier supplier1 = ()->{return "供给型接口2";};
        System.out.println(supplier.get()+"----"+supplier1.get());

        //消费型接口,有输入没输出
        Consumer consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> consumer1 = s->{
            System.out.println(s);
        };

        consumer.accept("消费型接口");
        consumer1.accept("消费型接口2");


        //判断型接口,有一个参数,返回boolean
        Predicate predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        };
        Predicate<String> predicate1 = s->{
            System.out.println(s);
            return false;
        };
        predicate.test("判断型接口");
        predicate1.test("判断型接口2");
    }
}
