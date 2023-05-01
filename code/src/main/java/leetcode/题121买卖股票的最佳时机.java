package leetcode;

/**
 * @author yang
 * 2021年06月09日 22:43:00
 */
public class 题121买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
