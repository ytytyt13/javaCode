package leetcode;

import java.util.Stack;
/**
 * @author yang
 * 2021年06月26日 18:23:00
 */
public class 题70爬楼梯 {
    public static void main(String[] args) {

        System.out.println(climbStairs(3));

    }

    public static int climbStairs(int n) {
       if (n <= 1) {
           return n;
       }
       int[] dp = new int[n+1];
       dp[0] = 1;
        for (int i = 0; i <=n; i++) {
            for (int j = 1; j <=2; j++) {
                if (i >= j) {
                    dp[i] += dp[i-j];
                }
            }
        }

        return dp[n];
    }

}
