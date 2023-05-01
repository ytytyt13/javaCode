package leetcode;

public class 题123买卖股票的最佳时机III {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        int n = prices.length-1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1] - prices[i], dp[i-1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        return Math.max(dp[n][1], Math.max(dp[n][2], dp[n][3]));
    }
}
