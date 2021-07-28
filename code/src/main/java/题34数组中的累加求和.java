/**
 * @author yang
 * 2021年05月11日 22:53:00
 */
public class 题34数组中的累加求和 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,5,46,1,3,2,2};
        int sum = 14;
        System.out.println(getSum(arr,0,sum,0));
    }

    public static boolean getSum(int[] arr, int i,int sum,int cur) {
        if (cur == sum) {
            return true;
        }
        if (i >= arr.length) {
            return false;
        }
        return getSum(arr,i+1,sum,cur)||getSum(arr,i+1,sum,cur+arr[i]);
    }
}
