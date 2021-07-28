package leetcode;

/**
 * @author yang
 * 2021年07月19日 22:52:00
 */
public class 题59螺旋矩阵II {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }

    public static int count;
    public static int[][] generateMatrix(int n) {
        if(n==0) {
            return new int[0][0];
        }
        int[][] res= new int[n][n];
        count = 1;
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        while (top <= down && left <= right) {
            getRes(res,top++,down--,left++,right--);
        }
        return res;

    }

    public static void getRes(int[][] res,int top,int down,int left ,int right) {
        for (int i = left; i <=right ; i++) {
            res[top][i] = count++;
        }
        for (int i = top+1; i <=down ; i++) {
            res[i][right] = count++;
        }
        for (int i = right-1; i >= left ; i--) {
            res[down][i] = count++;
        }
        for (int i = down-1; i >= top+1 ; i--) {
            res[i][left] = count++;
        }
    }
}
