package 牛渴;

/**
 * @author yang
 * 2021年04月11日 18:30:00
 */
public class 题02字符串替换 {
    public static void main(String[] args) {

        String s = "hello world";
        System.out.println(new 题02字符串替换().replaceSpace(s));
    }

    public String replaceSpace (String s) {
        // write code here
        char a = ' ';
        if (s == null || s.length() == 0)
            return s;
        StringBuilder sb =new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(a == chars[i]) {
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}



