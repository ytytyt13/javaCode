package leetcode;

import java.util.Arrays;

/**
 * @author yang
 * 2021年06月15日 20:28:00
 */
public class 题300最长递增子序列 {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && res[j] >= res[i]) {
                    res[i] = res[j]+1;
                }
            }
        }

        return Arrays.stream(res).max().getAsInt();


    }
}
