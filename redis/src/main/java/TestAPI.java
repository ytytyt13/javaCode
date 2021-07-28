import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yang
 * 2020年12月24日 15:03:00
 */
public class TestAPI {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.72.128",6379);
        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);
        System.out.println(keys);

        //System.out.println("---------------------exists-------------------------");
        //Boolean k2 = jedis.exists("k2");
        //System.out.println(k2);

        System.out.println("---------------------append-------------------------");
        //Long append = jedis.append("k1", "aaa");
        //System.out.println(append);

        List<String> list = Arrays.asList("1","2","3","4","5");
        List<String> collect = list.stream().map(o -> o + "s").collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}