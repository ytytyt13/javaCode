/**
 * @author yang
 * 2021年04月09日 23:01:00
 */
public class 算法06小和问题并归排序 {
    public static void main(String[] args) {
        int[] arr ={1,3,4,2,5};
        System.out.println(getMinAdd(arr,0,arr.length-1));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int getMinAdd(int[] arr,int l, int r) {
        if (l>=r) {
            return 0;
        }
        int m = l+((r-l)>>1);

        return getMinAdd(arr,l,m)+getMinAdd(arr,m+1,r)+merge(arr,l,m,r);
    }

    public static int merge(int[] arr,int l, int m ,int r) {
        int sum = 0;
        int[] help = new int[r-l+1];
        int i=l;
        int j=m+1;
        int p=0;
        while(i<=m && j<=r) {
            sum+=arr[i]<arr[j]?arr[i]*(r-j+1):0;
            help[p++] = arr[i]<arr[j]?arr[i++]:arr[j++];

        }


        while(i<=l){
            help[p++] = arr[i++];
        }

        while(j<=r){
            help[p++] = arr[j++];
        }

        for (int k = 0; k <help.length; k++) {
            arr[l+k]=help[k];
        }
        System.out.println("sum"+sum);
        return sum;
    }

}
