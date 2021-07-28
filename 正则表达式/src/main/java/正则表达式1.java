/**
 * @author yang
 * 2021年04月08日 14:40:00
 */
public class 正则表达式1 {
    public static void main(String[] args) {
        String query = "三亚湾红树林度假世界(大王棕酒店";
        String splitter = "AND";

        String var1= query.trim().replaceAll("([+\\-&|!(){}\\[\\]\\^\"~*?:\\\\<>\\s])", splitter);
        System.out.println(var1);

        String pattern = "^("+splitter+")?|("+splitter+")?$";

        String var2 = var1.trim().replaceAll(pattern, "");
        System.out.println(var2);

    }
}
