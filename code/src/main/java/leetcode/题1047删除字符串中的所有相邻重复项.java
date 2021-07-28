package leetcode;

import java.util.Stack;

/**
 * @author yang
 * 2021年07月25日 11:17:00
 */
public class 题1047删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {

    }

    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == st.peek()) {
                st.pop();
            }else {
                st.push(c);
            }
        }

        String res = "";
        while (!st.isEmpty()) {
            res = st.pop()+res;
        }

        return res;
    }
}
