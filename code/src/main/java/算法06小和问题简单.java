/**
 * @author yang
 * 2021年04月09日 00:07:00
 */
public class 算法06小和问题简单 {
    public static void main(String[] args) {
        int[] arr ={1,3,4,2,5};

        int[] temp=new int[arr.length];

        temp[0]=0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(arr[j]<arr[i]) {
                    temp[i]+=arr[j];
                }
            }
        }

        int sum =0;
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
            sum+=temp[i];
        }
        System.out.println(sum);
    }
}
