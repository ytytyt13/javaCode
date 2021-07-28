package leetcode;

/**
 * @author yang
 * 2021年07月07日 22:34:00
 */
public class 题377组合总和Ⅳ {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        System.out.println(combinationSum4(arr,5));

    }


    public static int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        return dp[target];

    }

}
