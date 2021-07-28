package leetcode;

import java.util.Stack;

/**
 * @author yang
 * 2021年06月15日 21:01:00
 */
public class 题20有效的括号 {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{') {
                st.push(temp);
            } else if (temp == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }else {
                    return false;
                }
            }else if (temp == ']') {
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                }else {
                    return false;
                }
            }else if (temp == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                }else {
                    return false;
                }
            }
        }

        return st.isEmpty()?true:false;
    }
}
