package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yang
 * 2021年05月30日 15:39:00
 */
public class 题215数组中的第K个最大元素 {
    public static void main(String[] args) {

        int[] arr = {3,2,3,1,2,4,5,5,6};

        //方法一:快排
        System.out.println(quickSort(arr, 0, arr.length - 1, arr.length-2));

        //方法2.堆排,先构建一个大根推,然后弹出k铬元素,第一个k个元素就是

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int quickSort(int[] arr,int left, int right,int k) {
        if (left >= right) {
            return arr[k];
        }
        int[] partition = partition(arr, left, right);
        int res =0;
        //如果k在右边,对右边继续排序
        if (k > partition[1]) {
            res = quickSort(arr,partition[1]+1,right,k);
        //如果k在左边,对左边继续排序
        }else if (k < partition[0]){
            res =quickSort(arr,left,partition[0]-1,k);
            //如果k在左边,对左边继续排序
        } else {
            res = arr[k];
        }
       return res;

    }


    public static int[] partition(int arr[],int left, int right) {
        int less = left -1;
        int more = right;

        while (left < more) {
            if (arr[left] > arr[right]) {
                swap(arr,--more,left);
            }else if (arr[left] < arr[right]) {
                swap(arr,++less,left++);
            }else  {
                left++;
            }
        }

        swap(arr,more,right);

        return new int[]{less+1,more};


    }

    //构建大根堆
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

    //弹出K次
    public int getMaxK(int[] arr,int k) {
        heapInsert(arr);
        int res = 0;
        for (int i = 0; i < k; i++) {
            heapify(arr,0,arr.length-1-i);
        }

        return arr[arr.length-k];
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

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
