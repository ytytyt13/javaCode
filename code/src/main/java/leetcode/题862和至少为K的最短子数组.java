package leetcode;

/**
 * @author yang
 * 2021年07月24日 18:09:00
 */
public class 题862和至少为K的最短子数组 {
    public static void main(String[] args) {
        int[] nums = {2,-1};
        System.out.println(shortestSubarray(nums, 3));
    }


    public static int shortestSubarray(int[] nums, int k) {
        if (nums==null || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = 1;
        int min=Integer.MAX_VALUE;
        int res= nums[0];
        while(right <= nums.length) {
            if (res < k && right < nums.length) {
                res+=nums[right];
                right++;
            } else if (res >k){
                res-=nums[left];
                left++;
            } else if (res == k) {
                min = Math.min(min,right-left);
                right++;
            }
        }
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        return -1;
    }
}
