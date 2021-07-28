package leetcode;

/**
 * @author yang
 * 2021年06月14日 14:52:00
 */
public class 题33搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(getNum(arr, 3));
    }

    public static int getNum(int[] num, int target) {
        int res =-1;
        if (num ==null || num.length < 1) {
            return res;
        }
        int left = 0;
        int right = num.length -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] < num[right]) {
                if (num[mid] < target && target <= num[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (num[mid] > target && target >= num[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
    }


}
