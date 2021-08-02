package 第6观察者模式;

/**
 * @author yang
 * 2021年08月02日 17:29:00
 */
public interface 通知者接口 {
    void attach(观察者接口 observer);
    void detach(观察者接口 observer);
    void Notify();
}
