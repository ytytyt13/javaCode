/**
 * @author yang
 * 2021年05月13日 21:44:00
 */
public class 题37回溯皇后问题 {

    private static int count = 0;
    private static int k = 8;
    private static int[] arr = new int[k];
    public static void main(String[] args) {

        getNQueue(0);
        System.out.println(count);

    }

    public static boolean check(int row, int col){
        for (int i = 0; i < row; i++) {
            if (arr[i] == col || Math.abs(row - i) == Math.abs(col - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void getNQueue(int n) {
        if (n == k) {
             count++;
             return ;
        }
        for (int i = 0; i < k; i++) {
            if (check(n,i)) {
                arr[n] = i;
                getNQueue(n+1);
            }
        }
    }
}
