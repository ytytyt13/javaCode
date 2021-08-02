package 第6观察者模式;

/**
 * @author yang
 * 2021年08月02日 16:51:00
 */
public class 观察者模式 {

    public static void main(String[] args) {
        通知者 通知者 = new 通知者();
        观察者1 a = new 观察者1("a", 通知者);
        观察者2 b = new 观察者2("b", 通知者);
        通知者.attach(a);
        通知者.attach(b);
        通知者.Notify();
    }

}
