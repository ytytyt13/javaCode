package leetcode;

/**
 * @author yang
 * 2021年07月13日 23:09:00
 */
public class 题4寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1= {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int num = (n1+n2)/2;
        int n = num+1;
        int[]  help = new int[n];
        int index =0;
        int index1 = 0;
        int index2 = 0;

        while (index < n && index1 < nums1.length && index2 < nums2.length ) {
            if (nums1[index1] < nums2[index2]) {
                help[index] = nums1[index1];
                index1++;
            }else {
                help[index] =  nums2[index2];
                index2++;
            }
            index++;
        }

        while (index < n && index1< nums1.length) {
            help[index] = nums1[index1];
            index1++;
            index++;
        }

        while (index < n && index2< nums2.length) {
            help[index] = nums2[index2];
            index2++;
            index++;
        }
        return (n1+n2)%2 == 0?(help[n-2]+help[n-1])/2.0:help[n-1];

    }
}
