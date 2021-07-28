package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author yang
 * 2021年06月26日 22:35:00
 */
public class 题39组合总和 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates,target,path,res,0);
        return res;

    }


    private static void dfs(int[] candidates, int target, List<Integer> path, List<List<Integer>> res,int index) {

        int sum = path.stream().mapToInt(o -> o).sum();
        if (sum > target) {
            return ;
        }
        if (sum == target) {
            res.add(path);
            return;
        }
        for (int i = index; i < candidates.length ; i++) {
            path.add(candidates[i]);
            dfs(candidates,target,new ArrayList<>(path),res,i+1);
            path.remove(path.size()-1);
        }
    }
}
