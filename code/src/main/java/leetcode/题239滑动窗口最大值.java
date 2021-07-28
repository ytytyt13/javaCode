package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * 2021年07月11日 19:56:00
 */
public class 题239滑动窗口最大值 {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return null;
        }
        int[] res = new int[nums.length-k+1];

        Deque<Integer> queue =  new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);

            if (queue.peekFirst() <= i-k) {
                queue.pollFirst();
            }
            if (i>=k-1) {
                res[i-k+1] = nums[queue.peekFirst()];
            }
        }

        return res;
    }


}
