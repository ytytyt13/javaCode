package leetcode;

/**
 * @author yang
 * 2021年07月04日 17:27:00
 */
public class 题221最大正方形 {
    public static void main(String[] args) {
        char[][] arr = {{'1','0'},{'0','1'}};
        System.out.println(maximalSquare(arr));

    }

    public static int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix == null || matrix.length < 1) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    res =  Math.max(res,dp[i][j]);
                }
            }
        }



        return res;
    }
}
