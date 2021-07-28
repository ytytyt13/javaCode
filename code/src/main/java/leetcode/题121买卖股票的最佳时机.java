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
        int min = 999999;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int temp = prices[i] - min;
            if (temp > 0 && temp > max) {
                max = temp;
            }
        }

        return max;
    }
}
