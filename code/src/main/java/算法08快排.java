import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

/**
 * @author yang
 * 2021年04月12日 22:59:00
 */
public class 算法08快排 {
    public static void main(String[] args) {
        int[] arr ={1,2,6,3,5,9,8,7,0};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void quickSort(int[] arr,int l, int r) {
        if (l >= r){
            return ;
        }
        int[] p = partition(arr,l,r);
        quickSort(arr,l,p[0]-1);
        quickSort(arr,p[1]+1,r);
    }

    public static int[] partition(int[] arr, int l,int r){
        int less = l-1;
        int more = r;
        while(l < more) {
            if (arr[l] >arr[r]) {
                swap(arr,--more,l);
            }else if (arr[l] <arr[r]) {
                swap(arr,++less,l++);
            }else {
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }

    public static void swap(int[] arr ,int i,int j) {
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
