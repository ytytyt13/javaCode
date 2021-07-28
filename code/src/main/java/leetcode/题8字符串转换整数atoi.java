package leetcode;

/**
 * @author yang
 * 2021年07月14日 23:07:00
 */
public class 题8字符串转换整数atoi {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoi("2147483646"));

    }

    public static int myAtoi(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int index = 0;
        int flag =1;
        int res = 0;
        while(index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) {
            return 0;
        }
        if (s.charAt(index) == '-' || s.charAt(index) == '+'){
            flag = s.charAt(index) == '-'?-1:1;
            index++;
        }

        while(index < s.length()) {
            Character c = s.charAt(index);
            if (c<'0' || c >'9') {
                break;
            }
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && c-'0' > Integer.MAX_VALUE%10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && -(c -'0') < Integer.MIN_VALUE%10)) {
                return Integer.MIN_VALUE;
            }
            res = res *10 + flag*(c-'0');
            index++;
        }
        return res;
    }
}
