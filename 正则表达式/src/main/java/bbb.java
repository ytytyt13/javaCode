import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yang
 * 2021年04月28日 17:04:00
 */
public class bbb {
    public static void main(String[] args) {
        List<Map<String, Object>> tagInfos = new ArrayList<>();

        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("title","5星酒店");
        map1.put("id",1);

        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("title","5星酒店星星");
        map2.put("id",2);

        HashMap<String,Object> map3 = new HashMap<>();
        map3.put("title","发5星发酒店");
        map3.put("id",3);

        HashMap<String,Object> map4 = new HashMap<>();
        map4.put("id",4);

        HashMap<String,Object> map5 = new HashMap<>();
        map5.put("title","星级餐厅");
        map5.put("id",5);


        tagInfos.add(map1);
        tagInfos.add(map2);
        tagInfos.add(map3);
        tagInfos.add(map4);
        tagInfos.add(map5);




        long time1 = System.currentTimeMillis();

        tagInfos.forEach(s->{
            if (s.get("title") != null) {
                s.put("title",regReplace(s.get("title").toString()));
            }
        });


        System.out.println(System.currentTimeMillis()-time1);

        tagInfos.forEach(s->{
            System.out.println(s.get("title"));
        });
    }

    public static String regReplace(String content){
        String pattern="\\d星|四星|五星";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        if (m.find()) {
            return  content.replace("星","钻");
        }
        return content;
    }

}
