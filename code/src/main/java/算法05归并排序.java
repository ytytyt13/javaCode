import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yang
 * 2021年04月08日 23:33:00
 */
public class 算法05归并排序 {

    public static void main(String[] args) {
        int arr[] ={1,46,5,63,7,7,11,3,363,7,3,7,8,7};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr,0,arr.length-1);

    }
    public static void sortProcess(int[] arr, int l,int r) {
        if (l==r) {
            return;
        }
        int m = l+((r-l)>>1);
        sortProcess(arr,l,m);
        sortProcess(arr,m+1,r);
        merge(arr,l,m,r);
    }

    public static void merge(int[] arr,int l,int m,int r) {
        int help[] = new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=m+1;
        while(p1<=m && p2<=r){
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=m) {
            help[i++]=arr[p1++];
        }

        while(p2<=r){
            help[i++]=arr[p2++];
        }

        for (int j = l; j < r+1; j++) {
            arr[j]=help[j-l];
        }

    }
}
