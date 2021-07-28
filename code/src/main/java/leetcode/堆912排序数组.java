package leetcode;

/**
 * @author yang
 * 2021年07月25日 17:34:00
 */
public class 堆912排序数组 {
    public static void main(String[] args) {

        int[] arr ={5,3,4,2,1};
        int[] ints = sortArray(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        heapInsert(nums);


        for (int i = nums.length-1; i > 0; i--) {
            swap(nums,0,i);
            heapFfy(nums,0,i);
        }
        return nums;
    }

    public static void heapInsert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int n = i;
            while(n>0) {
                int m = (n - 1) / 2;
                if (nums[m] < nums[n]) {
                    swap(nums, m, n);
                } else {
                    break;
                }
                n = m;
            }
        }
    }

    public static void heapFfy(int[] nums,int index,int heapSize) {
        int left = index*2+1;
        while(left < heapSize) {
            int largest = left+1<heapSize&&nums[left] < nums[left+1]?left+1:left;
            largest = nums[index]>nums[largest]?index:largest;
            if (index == largest) {
                break;
            }else {
                swap(nums,index,largest);
            }
            index = largest;
            left = index*2+1;
        }
    }

    public static void swap(int[] nums, int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
