package leetcode;

/**
 * @author yang
 * 2021年07月07日 23:00:00
 */
public class 题322零钱兑换 {
    public static void main(String[] args) {
        int[] arr ={1,2,5};
        coinChange(arr,11);

    }

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length < 1){
            return -1;
        }

        int[] dp = new int[amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount+1;
        }

        dp[0]=0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }


        return dp[amount]==amount+1?-1:dp[amount];
    }
}
