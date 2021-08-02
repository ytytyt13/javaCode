package 第6观察者模式;

/**
 * @author yang
 * 2021年08月02日 17:38:00
 */
public class 观察者1 extends 观察者接口 {

    public 观察者1(String name, 通知者接口 通知者) {
        super(name, 通知者);
    }

    @Override
    void update() {
        System.out.println(super.getName());
    }
}
