/**
 * @author yang
 * 2021年03月04日 19:54:00
 */
public class AAAimpl1 implements AAA {
    public static int a = getA();

    static {
        System.out.println("static方法执行");
    }

    public static int getA(){
        System.out.println("getA");
        return 0;
    }

    AAAimpl1(){
        System.out.println("初始化方法");
    }

    @Override
    public void test1() {
        System.out.println("AAAimpl1");
    }

    public static Integer b = 5;

    public static void test(Integer integer) {
        integer = integer+1;
    }

    public static void main(String[] args) {
        System.out.println("main");
        Integer a = new Integer(2);
        test(a);
        System.out.println(a);
    }
}
