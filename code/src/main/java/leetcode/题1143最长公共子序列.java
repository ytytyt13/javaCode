package leetcode;

/**
 * @author yang
 * 2021年07月12日 18:39:00
 */
public class 题1143最长公共子序列 {
    public static void main(String[] args) {

        longestCommonSubsequence("bsbininm",
                "jmjkbkjkv");
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 ==null) {
            return 0;
        }

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        return dp[text1.length()][text2.length()];
    }
}
