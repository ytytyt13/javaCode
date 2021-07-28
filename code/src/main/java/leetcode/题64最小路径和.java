package leetcode;

/**
 * @author yang
 * 2021年07月08日 23:34:00
 */
public class 题64最小路径和 {
    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1){
            return 0;
        }
        int[][]dp = new int[grid.length][grid[0].length];
        dp[0][0] =grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
