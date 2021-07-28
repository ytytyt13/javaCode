/**
 * @author yang
 * 2021年03月29日 16:18:00
 */
public class 算法02选择排序 {
    public static void main(String[] args) {
        int[] a = {1,2,4,3,4,6,5,62,3,62,62,5,26,7,3,73};
        for (int i = 0; i < a.length; i++) {
            int max_index = i;
            int max = a[i];
            for (int j = i+1; j < a.length; j++) {
                 if (max < a[j]) {
                     max=a[j];
                     max_index = j;
                 }
            }

            System.out.println("i:"+i);
            System.out.println("m:"+max_index);
            swap(a, i,max_index);

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
