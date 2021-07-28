package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * 2021年07月05日 21:41:00
 */
public class 题518零钱兑换II {
    public static void main(String[] args) {
        int amount= 5;
        int[] coins = {1,2,5};
        System.out.println(change(5, coins));
    }

    public static int change(int amount, int[] coins) {
        if (coins == null || coins.length < 1) {
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0]=1;
        for (int i = 0 ;i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] +=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }


}
