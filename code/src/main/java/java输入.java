import java.util.Scanner;

/**
 * @author yang
 * 2021年05月27日 21:15:00
 */
public class java输入 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);//定义scanner，等待输入
        System.out.println("请输入你的姓名:");
        String name = in.nextLine();//字符类型的输入方式
        System.out.println(name);
        System.out.println("请输入你的年龄：");
        int age = in.nextInt();//整数类型的输入方式
        System.out.println(age);
        System.out.println("请输入你的身高：");
        double height = in.nextDouble();//小数类型的输入方式
        System.out.println(height);

    }
}
