
package leetcode;

/**
 * @author yang
 * 2021年07月03日 20:13:00
 */
public class 题162寻找峰值 {
    public static void main(String[] args) {

    }

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length <1) {
            return -1;
        }
        int l = 0;
        int r = nums.length-1;

        while(l<r) {
            int mid = (l+r)/2;
            if (nums[mid]>nums[mid+1]) {
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return r;
    }
}
