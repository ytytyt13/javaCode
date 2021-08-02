package 第5构建者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * 2021年08月02日 16:10:00
 */
public class 产品 {
    public List<String> 构成组件 = new ArrayList<>();

    public void 设置部件(String 部件) {
        构成组件.add(部件);
    }

    public void show(){
        构成组件.forEach(System.out::println);
    }
}
