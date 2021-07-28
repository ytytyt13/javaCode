package leetcode;

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
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]-prices[i-1] > 0) {
                res +=(prices[i]-prices[i-1]);
            }
        }

        return res;
    }
}
