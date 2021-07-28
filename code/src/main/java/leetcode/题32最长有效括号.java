package leetcode;

import java.util.Stack;
/**
 * @author yang
 * 2021年06月26日 22:20:00
 */
public class 题32最长有效括号 {
    public static void main(String[] args) {

    }

    public static int longestValidParentheses(String s) {
        if (s ==null || s.length() < 1){
            return 0;
        }
        Stack<Character> st = new Stack<>();
        int num =0;
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if (!st.isEmpty() && c == ')') {
                if (st.peek() == '(') {
                    num+=2;
                    st.pop();
                }else if (c == st.peek()){
                    st.push(c);
                }
            }else {
                st.push(c);
            }
        }

        return num;
    }
}

