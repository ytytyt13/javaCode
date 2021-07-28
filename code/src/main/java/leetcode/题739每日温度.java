package leetcode;

import java.util.Stack;

/**
 * @author yang
 * 2021年07月19日 21:27:00
 */
public class 题739每日温度 {
    public static void main(String[] args) {

        int[]  temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(temperatures);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                res[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        res[size-1] = 0;
        return res;
    }
}
