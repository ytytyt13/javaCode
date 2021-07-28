package leetcode;

/**
 * @author yang
 * 2021年07月25日 12:13:00
 */
public class 题189旋转数组 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return ;
        }
        swap(nums,0,nums.length-1);
        swap(nums,0,k-1);
        swap(nums,k,nums.length-1);

    }

    public static void swap(int[] nums,int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
