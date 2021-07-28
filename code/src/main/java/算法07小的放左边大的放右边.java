/**
 * @author yang
 * 2021年04月09日 23:42:00
 */
public class 算法07小的放左边大的放右边 {
    public static void main(String[] args) {
        int[] arr ={1,3,4,5,2,33,4,2,33,22,11,10,2,5,9,7,7,36,88,3,7,11,23,33};
        insertMid(arr,10);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void insertMid(int[] arr,int m) {
        int l = 0;
        int r= arr.length-1;
        int i=0;
        while(l<r) {
            if (arr[l] > m) {
                swap(arr, l, r--);
            } else if(arr[l] ==m) {
                swap(arr, l, r);
            }else{
                l++;
            }

        }
    }

    public static void swap(int[] arr ,int i,int j) {
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
