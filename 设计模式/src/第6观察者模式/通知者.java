package 第6观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * 2021年08月02日 17:36:00
 */
public class 通知者 implements 通知者接口 {

    List<观察者接口> 观察者 = new ArrayList<>();
    @Override
    public void attach(观察者接口 observer) {
        观察者.add(observer);
    }

    @Override
    public void detach(观察者接口 observer) {
        观察者.remove(observer);
    }

    @Override
    public void Notify() {
        观察者.forEach(o->o.update());
    }
}
