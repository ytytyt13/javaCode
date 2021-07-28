/**
 * @author yang
 * 2021年04月21日 22:52:00
 */
public class 算法09堆排序 {
    public static void main(String[] args) {
        int[] arr = {1,3,6,2,4,2,5};
        heapInsert(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            swap(arr,0,arr.length-1-i);
            heapify(arr,0,arr.length-1-i);
        }
        System.out.println("-------------------");

        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int n = i;
            while(n>0) {
                int m = (n-1)>>1;
                if (arr[m]<arr[n]) {
                    swap(arr,n,m);
                }else{
                    break;
                }
                n=m;

            }
        }
    }

    public static void heapify(int[] arr,int index,int heapSize) {
        int left = index*2+1;
        while(left < heapSize) {
            int largest = left+1<heapSize && arr[left+1]>arr[left]?
                    left+1:left;
            largest = arr[largest] > arr[index]?largest:index;
            if (largest == index) {
                break;
            }
            swap(arr,largest,index);
            index =largest;
            left = index*2+1;

        }
    }

    public static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
