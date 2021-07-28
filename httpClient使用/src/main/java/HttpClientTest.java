import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * 2021年04月14日 11:07:00
 */
public class HttpClientTest {
    public static void main(String[] args) {
        //设置用户名和密码
        Map<String, String> map = new HashMap<String,String>();
        map.put("username", "admin");
        map.put("password", "123456");

        //需要先通过springSecurity认证
        //String s1 =  new HttpClientUtil.post("http://localhost:9101/login", map);

        Map<String, String> brand = new HashMap<String,String>();
        brand.put("name", "123456");
        brand.put("firstChar", "T");

        String jsonMap = JSON.toJSONString(brand);
        System.out.println(jsonMap);
        //String s2 = HttpClientUtil.doPostJson("http://localhost:9101/brand/add.do", jsonMap);

        //String s2 = HttpClientUtil.doGet("http://localhost:9101/brand/findAll.do");
        //System.out.println(s2);
    }
}
