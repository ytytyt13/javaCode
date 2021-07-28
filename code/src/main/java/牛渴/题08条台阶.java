package 牛渴;

/**
 * @author yang
 * 2021年04月11日 19:30:00
 */
public class 题08条台阶 {
    public static void main(String[] args) {
        System.out.println(new 题08条台阶().jumpFloor(4));
    }

    public int jumpFloor(int target) {
        if (target < 0)
            return 0;
        if (target < 3)
            return target;
        int sum = 0;
        int before1 = 1;
        int before2 = 2;
        for (int i = 3; i <=target ; i++) {
            sum = before1+before2;
            before1 = before2;
            before2 = sum;
        }

        return sum;
    }
}
