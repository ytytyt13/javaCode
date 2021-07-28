package leetcode;

import java.util.Arrays;

/**
 * @author yang
 * 2021年06月15日 20:42:00
 */
public class 题31下一个排列 {
    public static void main(String[] args) {

    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return ;
        }

        int n = nums.length;

        for (int i = n-1; i > 0 ; i--) {
            if (i == 0){
                Arrays.sort(nums);
                return ;
            }else {
                if (nums[i] > nums[i-1]) {
                    Arrays.sort(nums,i,n);
                    for (int j = i; j < n; j++) {
                        if (nums[j] > nums[i-1]) {
                            int temp = nums[j];
                            nums[j] = nums[i-1];
                            nums[i-1] =temp;
                            return;
                        }
                    }
                }
            }

        }

    }
}
