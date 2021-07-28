/**
 * @author yang
 * 2021年05月11日 22:42:00
 */
public class 题33矩阵向下走求最小值 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,0,4},
                       {3,2,0,1},
                       {3,2,1,0},
                       {3,4,1,2}};

        System.out.println(getNum(arr, 0, 0));

    }

    public static int getNum(int[][] arr,int i,int j) {
        if (i == arr.length-1 && j == arr[0].length-1 ) {
            return arr[i][j] ;
        }
        if (i == arr.length -1) {
            return arr[i][j] + getNum(arr,i,j+1);
        }
        if (j == arr[0].length-1) {
            return arr[i][j] +getNum(arr,i+1,j);
        }
        return arr[i][j] + Math.min(getNum(arr,i+1,j),getNum(arr,i,j+1));
    }
}
