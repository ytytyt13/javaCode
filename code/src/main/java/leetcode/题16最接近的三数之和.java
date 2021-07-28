package leetcode;

import java.util.Arrays;

/**
 * @author yang
 * 2021年07月25日 18:30:00
 */
public class 题16最接近的三数之和 {
    public static void main(String[] args) {
        int[] arr ={-1,2,1,-4};
        System.out.println(threeSumClosest(arr, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        Arrays.sort(nums);

        int temp = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int left = i+1;
            int right  = nums.length-1;
            while(left < right) {
                int add =  num1+nums[left]+nums[right];
                if (Math.abs(add-target) < temp) {
                    temp = Math.abs(add-target);
                    res = add;
                }
                if (add > target) {
                    right--;
                }else if (add < target) {
                    left++;
                }else if (add == target) {
                    return add;
                }
            }
        }
        return res;
    }
}
