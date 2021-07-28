package leetcode;

/**
 * @author yang
 * 2021年07月10日 14:06:00
 */
public class 题695岛屿的最大面积 {
    public static void main(String[] args) {

    }
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(getMax(grid,i,j),max);
            }
        }

        return max;

    }

    public static int getMax(int[][] grid, int m, int n) {
        if(m< 0 || m >= grid.length || n < 0 || n >=grid[0].length || grid[m][n] != 1) {
            return 0;
        }
        if (grid[m][n] == 1) {
            grid[m][n]=0;
        }
        return 1+getMax(grid,m-1,n)+getMax(grid,m+1,n)+getMax(grid,m,n-1)+getMax(grid,m,n+1);
    }
}
