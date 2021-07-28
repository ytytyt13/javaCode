package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author yang
 * 2021年07月12日 16:05:00
 */
public class 题394字符串解码 {
    public static void main(String[] args) {
        String s= "3[a]2[bc]";
        System.out.println(decodeString(s));

    }

    public static String decodeString(String s) {
        if (s == null) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<String> sStack = new Stack<>();
        Stack<Integer> dStack = new Stack<>();
        for(Character c:s.toCharArray()) {
            if (c == '[') {
                sStack.push(res.toString());
                dStack.push(multi);
                res = new StringBuilder();
                multi = 0;
            }else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int mulNum = dStack.pop();
                for (int i = 0; i < mulNum; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(sStack.pop() + temp);
            }else if (c >= '0' && c <= '9') {
                multi = multi*10+Integer.parseInt(c+"");
            }else {
                res.append(c);
            }
        }

        return res.toString();

    }
}
