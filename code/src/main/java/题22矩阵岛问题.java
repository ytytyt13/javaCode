/**
 * @author yang
 * 2021年04月28日 22:43:00
 */
public class 题22矩阵岛问题 {
    public static void main(String[] args) {

        int[][] arr = {{1, 1, 0, 1, 0, 1},
                       {1, 1, 0, 0, 0, 1},
                       {0, 0, 0, 0, 0, 0},
                       {1, 0, 1, 0, 0, 0}};

        System.out.println(getIsland(arr));
    }

    public static int getIsland(int[][] arr){
        if (arr == null) {
            return 0;
        }
        int N = arr.length;
        int M = arr[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    res++;
                    infect(arr,i,j,N,M);
                }
            }
        }

        return res;
    }

    public static void infect(int[][] arr,int i, int j, int N,int M) {
        if ( i< 0 ||i >= N || j< 0 || j>= M || arr[i][j] != 1 ) {
            return;
        }
        arr[i][j] = 2;
        infect(arr,i+1, j, N, M);
        infect(arr,i-1, j, N, M);
        infect(arr,i, j+1, N, M);
        infect(arr,i, j-1, N, M);
    }
}
