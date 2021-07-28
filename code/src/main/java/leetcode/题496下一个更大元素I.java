package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * @author yang
 * 2021年07月19日 21:55:00
 */
public class 题496下一个更大元素I {
    public static void main(String[] args) {

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] minStack = getMinStack(nums2);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < minStack.length; i++) {
            map.put(nums2[i],minStack[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;

    }

    public static int[] getMinStack(int[] nums2) {
        int size = nums2.length;
        Stack<Integer> st = new Stack<>();
        int[] res= new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < size; i++) {
            while (!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
                Integer pop = st.pop();
                res[pop] = nums2[i];
            }
            st.push(i);
        }
        res[size-1] = -1;
        return res;
    }

}
