/**
 * @author yang
 * 2021年03月29日 16:54:00
 */
public class 算法03插入排序 {
    public static void main(String[] args) {
        int[] a = {1,2,4,3,4,6,5,62,3,62,62,5,26,7,3,73};

        for (int i = 1; i <a.length ; i++) {
            for (int j = i; j > 0 ; j--) {
                if (a[j] > a[j-1])
                    swap(a, j,j-1);
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void swap(int[] a,int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}