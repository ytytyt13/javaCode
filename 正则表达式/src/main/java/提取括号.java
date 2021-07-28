import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yang
 * 2021年06月11日 12:56:00
 */
public class 提取括号 {
    public static void main(String[] args) {
         String PATTERN = "(?<=\\{|\\()[^\\}|\\)]+";

         String queryWord = "rid(123,4,5,67)aa{12345}";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(queryWord);
        if (match.find()) {
            System.out.println(match.group());
        }

        System.out.println("------------");

        String s = "「官方自营」ddddddddddddd「亲子\uD83D\uDC9E情侣优选」三亚丽禾温德姆酒店，雅致海景房4晚\uD83D\uDC33黄金地段";
        String result = s.replaceAll("\\「[^\\(^\\)]*\\」", "");
        System.out.println(s);
        System.out.println(result);

        System.out.println("-----------------");
        getRes(s);

    }

    public static String getRes(String s) {
        if (s==null) {
            return "";
        }
        Queue<Integer> num = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if ("「".equals(s.charAt(i)) || "」".equals(s.charAt(i))) {
                num.add(i);
            }
        }

        while(num.size() > 1) {
            int inddx1 = num.poll();
            int inddx2 = num.poll();

        }
        return null;
    }
}
