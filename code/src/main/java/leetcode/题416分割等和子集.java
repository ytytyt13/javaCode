package leetcode;

/**
 * @author yang
 * 2021年07月08日 22:55:00
 */
public class 题416分割等和子集 {
    public static void main(String[] args) {
        int[]  arr ={1,2,5};
        System.out.println(canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {
        if (nums == null | nums.length < 1) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i <nums.length; i++) {
            sum += nums[i];
        }
        if (sum%2 != 0) {
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >=nums[i]; j--) {
                if(dp[j-nums[i]]) {
                    dp[j] = true;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]+",");
        }

        return dp[target];
    }
}
