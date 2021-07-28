package leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang
 * 2021年06月02日 22:27:00
 */
public class 题015三数之和 {
    public static void main(String[] args) {
        int[] nums = {0,0,0};

        List<List<Integer>> lists = threeSum(nums);

        lists.forEach(o->o.forEach(s-> System.out.println(s)));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        //十分重要
        Arrays.sort(nums);
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] > 0) {
                break;
            }
            int left = i+1;
            int right = nums.length -1;
            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if ( sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //去重
                    while(left < right && nums[left+1] == nums[left]) {
                        left++;
                    }
                    while(left< right && nums[right-1]== nums[right]) {
                        right--;
                    }
                    left++;
                    right--;

                }
                else if (sum > 0) {
                    right--;
                }else {
                    left++;
                }
            }
            while( i < nums.length -1 && nums[i]==nums[i+1] ) {
                i++;
            }
        }
        return res;
    }
}
