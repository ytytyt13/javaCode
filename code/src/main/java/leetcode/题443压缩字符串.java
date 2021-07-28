package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yang
 * 2021年07月25日 16:45:00
 */
public class 题443压缩字符串 {
    public static void main(String[] args) {
        char[] arr ={'a','a','b','b','c','c','c'};
        System.out.println(compress(arr));
    }

    public static char[] compress(char[] chars) {
        if (chars == null || chars.length < 1) {
            return new char[0];
        }
        if (chars.length == 1) {
            return chars;
        }
        Stack<Character> st = new Stack<>();
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (st.isEmpty()) {
                st.push(c);
                continue;
            }else if (c == st.peek()) {
                st.push(c);
            }else {
                int size = st.size();
                res.add(st.peek());
                Stack<Character> temp = new Stack<>();
                while(size > 0) {
                    temp.push((char) (size%10+48));
                    size = size/10;
                }

                while(!temp.isEmpty()) {
                    res.add(temp.pop());
                }
                st.clear();
                st.push(c);
            }
        }
        if (!st.isEmpty()) {
            int size = st.size();
            res.add(st.peek());
            Stack<Character> temp = new Stack<>();
            while(size > 0) {
                temp.push((char) (size%10+48));
                size = size/10;
            }
            while(!temp.isEmpty()) {
                res.add(temp.pop());
            }
        }
        char[] r = new char[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
