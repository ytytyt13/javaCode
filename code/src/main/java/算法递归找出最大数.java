/**
 * @author yang
 * 2021年04月08日 23:19:00
 */
public class 算法递归找出最大数 {
    public static void main(String[] args) {
        int[] arr={1,2,5,34,5,6,73,3,3,6,37,373,5,63,3,55,37,3,7,3,7,37};
        System.out.println(getMax(arr, 0, arr.length - 1));

    }

    public static int getMax(int[] arr,int l, int r) {
        System.out.println(l+","+r);
        if (l>=r) {
            return arr[l];
        }
        int mid = (r+l)/2;
        int lmax=getMax(arr,l,mid);
        int rmax=getMax(arr,mid+1,r);
        return Math.max(lmax,rmax);
    }
}
