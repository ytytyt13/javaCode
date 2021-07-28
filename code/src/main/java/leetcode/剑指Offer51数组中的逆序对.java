package leetcode;

/**
 * @author yang
 * 2021年07月24日 10:33:00
 */
public class 剑指Offer51数组中的逆序对 {
    public static void main(String[] args) {
        int[] arr = {7,5,6,4,4,5,3,6,2,6,2,6,6,6,2,7,4,44,73,7,37,3,7,3,};
        System.out.println(reversePairs(arr));
    }
    public static int reversePairs(int[] nums) {
        if (nums==null || nums.length <2) {
            return 0;
        }
        return getPairs(nums,0,nums.length-1);
    }

    public static int getPairs(int nums[], int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left+right) /2 ;
        int leftPairs = getPairs(nums,left,mid);
        int rightPairs = getPairs(nums,mid+1,right);
        int megerPairs = merge(nums,left,mid,right);
        return leftPairs+rightPairs+megerPairs;
    }

    public static int merge(int[] nums,int left, int mid,int right){
        if (left == right) {
            return 0;
        }
        int i =left;
        int j = mid+1;
        int index = left;
        int count= 0;
        int[] temp = new int[nums.length];
        for (int k = left; k < right+1; k++) {
            temp[k] = nums[k];
        }

        while(i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[index]= temp[i];
                i++;
                index++;
            }else {
                nums[index] = temp[j];
                count += (mid-i+1);
                j++;
                index++;
            }
        }
        while(i <= mid ){
            nums[index]= temp[i];
            i++;
            index++;
        }
        while(j <= right) {
            nums[index]= temp[j];
            j++;
            index++;
        }
        return count;
    }
}
