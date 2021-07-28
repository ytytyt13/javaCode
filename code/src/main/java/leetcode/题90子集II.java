package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * 2021年07月10日 17:55:00
 */
public class 题90子集II {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        getRes(nums,0,res,temp);

        return res;
    }

    public static void getRes(int nums[], int index ,List<List<Integer>> res, List<Integer> path) {
        res.add(path);
        for (int i = index; i < nums.length; i++) {
            if (i> index && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            getRes(nums,i+1,res,new ArrayList<Integer>(path));
            path.remove(path.size()-1);
        }
    }
}
