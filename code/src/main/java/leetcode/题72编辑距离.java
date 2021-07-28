package leetcode;

/**
 * @author yang
 * 2021年07月12日 18:13:00
 */
public class 题72编辑距离 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));

    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = dp[i-1][0]+1;
        }

        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = dp[0][i-1]+1;
        }
        for (int i = 1; i <= word1.length() ; i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int del = dp[i][j-1] +1;
                int add = dp[i-1][j]+1;
                int replace = dp[i-1][j-1];
                if (word1.charAt(i-1)!=word2.charAt(j-1)){
                    replace += 1;
                };
                dp[i][j] = Math.min(del,Math.min(add,replace));
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
