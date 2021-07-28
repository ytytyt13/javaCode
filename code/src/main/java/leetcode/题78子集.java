package leetcode;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * 2021年07月10日 14:20:00
 */
public class 题78子集 {
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        List<List<Integer>> subsets = subsets(arr);

        subsets.forEach(o->{
            o.forEach(System.out::print);
            System.out.println();
        });

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
        }
    }
}
