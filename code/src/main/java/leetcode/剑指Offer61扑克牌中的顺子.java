package leetcode;

import java.util.Arrays;

/**
 * @author yang
 * 2021年07月25日 17:22:00
 */
public class 剑指Offer61扑克牌中的顺子 {
    public static void main(String[] args) {

    }

    public static boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 5) {
            return false;
        }
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
                continue;
            }else if (i > 0 && nums[i] == nums[i-1]) {
                return false;
            }
        }
        return nums[nums.length-1] - nums[zero] < 5;
     }
}
