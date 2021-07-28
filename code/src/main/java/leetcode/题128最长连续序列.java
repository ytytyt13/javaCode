package leetcode;

import java.util.HashSet;

/**
 * @author yang
 * 2021年07月19日 21:21:00
 */
public class 题128最长连续序列 {
    public static void main(String[] args) {

        int[] arr ={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] nums) {
        if (nums.length ==0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 1;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]-1)) {
                continue;
            }
            int num = nums[i];
            int count = 0;
            while(set.contains(num)) {
                count++;
                num++;
            }
            if (count > res) {
                res = count;
            }
        }
        return res;
    }
}
