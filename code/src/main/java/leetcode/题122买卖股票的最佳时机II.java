package leetcode;

import javax.swing.plaf.multi.MultiTableHeaderUI;

/**
 * @author yang
 * 2021年06月28日 22:12:00
 */
public class 题122买卖股票的最佳时机II {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices == null || prices.length < 1) {
            return res;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i], dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }
}
