package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * 2021年06月12日 18:55:00
 */
public class 题1两数之和 {
    public static void main(String[] args) {

        int[] nums = {1,4,6,3,2,5};
        int[] ints = twoSum(nums, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i <nums.length; i++) {
            Integer other = map.get(target-nums[i]);
            if (other != null && other != i ) {
                return new int[]{other,i};
            }
        }
        return null;
    }



    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            Integer other = map.get(target-nums[i]);
            if (other != null && other != i ) {
                return new int[]{other,i};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
