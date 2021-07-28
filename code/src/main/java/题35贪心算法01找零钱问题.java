/**
 * @author yang
 * 2021年05月12日 21:38:00
 */
public class 题35贪心算法01找零钱问题 {
    public static void main(String[] args) {
        int money = 41;
        int money25 = 0;
        int money10 = 0;
        int money5 = 0;
        int money1 = 0;

        int count = 0;
        while (money > 0) {
            if (money >= 25) {
                money -=25;
                money25++;
            }else if (money >= 10 && money < 25  ) {
                money -= 10;
                money10++;
            }else if (money>= 5 && money < 10) {
                money -= 5;
                money5++;
            }else if (money < 5) {

                money1 =+ money;
                money=0;
            }
        }

        System.out.println(money25);
        System.out.println(money10);
        System.out.println(money5);
        System.out.println(money1);

        System.out.println(money25+money10+money5+money1);
    }
}
