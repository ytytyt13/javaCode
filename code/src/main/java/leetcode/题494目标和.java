package leetcode;

/**
 * @author yang
 * 2021年07月08日 23:22:00
 */
public class 题494目标和 {
    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (target > sum ||(sum +target)% 2 != 0) {
            return 0;
        }
        int temp = (sum + target)/2;
        int[] dp = new int[temp+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = temp; j >= nums[i] ; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }


        return dp[temp];
    }
}
