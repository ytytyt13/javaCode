package leetcode;

import java.util.Arrays;

/**
 * @author yang
 * 2021年07月07日 23:15:00
 */
public class 题279完全平方数 {
    public static void main(String[] args) {

        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i*i; j <=n; j++) {
                dp[j] =  Math.min(dp[j],dp[j-i*i]+1);
            }
        }

        return dp[n];
    }
}
