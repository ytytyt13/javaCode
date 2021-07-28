package leetcode;

/**
 * @author yang
 * 2021年06月13日 15:50:00
 */
public class 题200岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        System.out.println(numIslands(grid));

    }


    public static int numIslands(char[][] grid) {
        if(grid == null) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    infect(grid,i,j);
                }
            }
        }

        return res;
    }

    public static void infect(char[][] grid, int i,int j){
        if (grid[i][j] != '1') {
            return ;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
        }
        //感染上面
        if (i >0) {
            infect(grid,i-1,j);
        }
        if (i < grid.length -1) {
            infect(grid,i+1,j);
        }

        if (j>0){
            infect(grid,i,j-1);
        }

        if (j< grid[0].length-1){
            infect(grid,i,j+1);
        }
    }
}
