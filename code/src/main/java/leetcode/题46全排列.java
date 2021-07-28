package leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yang
 * 2021年06月15日 22:24:00
 */
public class 题46全排列 {
    public static void main(String[] args) {

        int[] arr ={1,2,3};
        List<List<Integer>> permute = permute(arr);

        permute.forEach(o->{o.forEach(n-> System.out.print(n));
            System.out.println();});

    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        List<List<Integer>>  res =new ArrayList<>();
        getRes(res,nums,0);
        return res;

    }


    public static void getRes(List<List<Integer>> res,int[] nums, int n) {
        if (n == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = n; i < nums.length; i++) {
            swap(nums,i,n);
            getRes(res,nums,n+1);
            swap(nums,i,n);
        }
    }

    public static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

