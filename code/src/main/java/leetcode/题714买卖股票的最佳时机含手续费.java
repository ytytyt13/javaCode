package leetcode;

public class 题714买卖股票的最佳时机含手续费 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null|| prices.length< 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][i], dp[i-1][0] + prices[i] - fee);
        }
        return dp[prices.length-1][1];
    }
}
