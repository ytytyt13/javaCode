package leetcode;

/**
 * @author yang
 * 2021年06月29日 13:13:00
 */
public class 题48图像旋转 {
    public static void main(String[] args) {

    }

    public static void getRes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int r = matrix.length/2;
        int b = matrix[0].length;
        int T = 0;
        int D = matrix.length -1;
        int L = 0;
        int R = matrix[0].length -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < b-1; j++) {
                swap(matrix,T,L+j,T+j,R);
                swap(matrix,T,L+j,D,R-j);
                swap(matrix,T,L+j,D-j,L);

            }
            T++;
            D--;
            L++;
            R--;
            b-=2;
        }
    }


    public static void swap(int[][] arr, int i1, int j1, int i2, int j2) {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }
}
