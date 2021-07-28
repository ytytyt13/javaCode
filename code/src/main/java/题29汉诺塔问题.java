/**
 * @author yang
 * 2021年05月10日 22:47:00
 */
public class 题29汉诺塔问题 {
    public static void main(String[] args) {
        process(3,"左","右","中");
    }

    public static void process(int N, String from, String to, String help) {
        if (N ==1) {
            System.out.println("move "+ N +" from "+ from+" to "+ to);
        }else {
            process(N-1, from, help,to);
            System.out.println("move "+ N +" from "+ from+" to "+ to);
            process(N-1,help,to,from);
        }
    }
}
