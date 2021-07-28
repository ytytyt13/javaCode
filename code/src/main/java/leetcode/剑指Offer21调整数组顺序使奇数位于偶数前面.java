package leetcode;

/**
 * @author yang
 * 2021年07月17日 23:00:00
 */
public class 剑指Offer21调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] exchange = exchange(arr);
        for (int i = 0; i < exchange.length; i++) {
            System.out.println(exchange[i]);
        }
    }

    public static int[] exchange(int[] nums) {
        int left= 0;
        int right = nums.length-1;

        while(left <= right) {
            if (nums[left]%2 != 0){
                left ++;
                continue;
            }
            if (nums[right]%2 ==0) {
                right--;
                continue;
            }
            swap(nums,left++,right--);
        }
        return nums;
    }

    public static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
