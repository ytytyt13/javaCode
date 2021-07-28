package leetcode;

/**
 * @author yang
 * 2021年06月12日 22:06:00
 */
public class 题88合并两个有序数组 {
    public static void main(String[] args) {

        int[] nums1 = {2,0};
        int[] nums2 = {1};
        merge(nums1,1,nums2,nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length < 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
            for (int j = m+i; j > 0 ; j--) {
                if (nums1[j] < nums1[j-1]) {
                    swap(nums1,j,j-1);
                }
            }
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
