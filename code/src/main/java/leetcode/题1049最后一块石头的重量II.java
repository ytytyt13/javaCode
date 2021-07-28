package leetcode;

/**
 * @author yang
 * 2021年07月08日 23:09:00
 */
public class 题1049最后一块石头的重量II {
    public static void main(String[] args) {

    }

    public static int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length < 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int target = sum/2;

        int[] dp = new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >=stones[i] ; j--) {
                dp[j] =Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

        return sum - 2*dp[target];
    }
}
