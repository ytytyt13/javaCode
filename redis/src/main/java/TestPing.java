/**
 * @author yang
 * 2020年12月24日 14:53:00
 */
import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args)
    {
        Jedis jedis = new Jedis("192.168.72.128",6379);
        //输出PONG，redis连通成功
        System.out.println(jedis.ping());
    }
}
