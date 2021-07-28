package 牛渴;

import java.util.Stack;

/**
 * @author yang
 * 2021年04月20日 23:40:00
 */
public class 题20包含min函数的栈 {
    public static void main(String[] args) {

    }

    public static class Solution {

        private static Stack<Integer> s = new Stack<Integer>();
        private static Stack<Integer> mins = new Stack<Integer>();
        public void push(int node) {
            s.push(node);
            if (mins.isEmpty()) {
                mins.push(node);
            }else if (node < mins.peek()) {
                mins.push(node);
            }

        }

        public void pop() {
            Integer pop = s.pop();
            if (mins.peek() == pop) {
                mins.pop();
            }
        }

        public int top() {
            return s.peek();
        }

        public int min() {
            return mins.peek();
        }
    }
}
