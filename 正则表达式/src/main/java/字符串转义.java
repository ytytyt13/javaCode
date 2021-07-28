import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yang
 * 2021年04月08日 22:00:00
 */
public class 字符串转义 {
    public static void main(String[] args) {

        String str = "三亚湾红树林度假世界(大王棕酒店)";

        System.out.println(org.springframework.web.util.HtmlUtils.htmlEscape(str));

        System.out.println(org.apache.commons.lang.StringEscapeUtils.escapeHtml(str));


        str = "三亚湾红(){}[[[树林度假世界(大王棕酒店)+";
        StringBuilder stringBuilder = new StringBuilder(str);
        //String regEx = "[`~!@#$%^&*()\\-+={}':;,\\[\\].<>/?￥%…（）_+|【】‘；：”“’。，、？\\s]";
        String regEx = "[&|!(){}\\[\\]^\"~*?:/+\\-]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        //System.out.println(m.start());
        int i=0;
        while(m.find()){
            //System.out.println(m.start());
            System.out.println(m.group());
            stringBuilder.insert(m.start()+(i++),"\\");
        }

        System.out.println(stringBuilder.toString());


        StringBuffer sb = new StringBuffer();
        String input = "北京iHOME短住公寓(国贸店)(8号店)";
        String regex = "[+\\-&|!(){}\\[\\]^\"~*?:(\\)\\s]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            matcher.appendReplacement(sb, "\\\\"+matcher.group());
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());

        Map<String,String> map= new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");

        String remove = map.remove(4);

    }
}
