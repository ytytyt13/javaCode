package 牛渴;

/**
 * @author yang
 * 2021年04月11日 19:43:00
 */
public class 题09跳n级台阶 {
    public static void main(String[] args) {
        System.out.println(new 题09跳n级台阶().jumpFloorII(3));
    }

    public int jumpFloorII(int target) {
        if (target < 0)
            return 0;
        if (target < 3)
            return target;

        int[] temp = new int[target+1];
        temp[0]=0;
        temp[1]=1;
        temp[2]=2;
        for (int i = 3; i <= target ; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum+=temp[j];
            }
            temp[i] =sum;
        }

        return temp[target]+1;
    }
}
