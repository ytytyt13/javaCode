package leetcode;

/**
 * @author yang
 * 2021年07月10日 18:48:00
 */
public class 题151翻转字符串里的单词 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello   world  "));

    }

    public static String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        //去空
        StringBuilder stringBuilder = trimStirng(s);
        //反转
        stringBuilder.reverse();
        //反转单词
        return reverseWord(stringBuilder.toString());

    }

    public static StringBuilder trimStirng(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int begin = 0;
        while (s.charAt(begin) == ' ') {
            begin++;
        }
        int end = s.length()-1;
        while(s.charAt(end) == ' ') {
            end--;
        }
        while (begin <= end) {
            if (s.charAt(begin)==' ' && s.charAt(begin-1)==' ') {
                begin++;
            }
            stringBuilder.append(s.charAt(begin++));
        }
        return stringBuilder;
    }



    public static String reverseWord(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            if (stringBuilder.charAt(right) == ' ') {
                rev(stringBuilder,left,right-1);
                left = right+1;
            }else if (right == s.length()-1) {
                rev(stringBuilder,left,right);
            }
            right++;
        }
        return stringBuilder.toString();
    }


    public static void rev(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }
}

