package 第4模板方法模式;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yang
 * 2021年08月02日 14:51:00
 */
/*
* 模板方法模式:
* 1.将公共的方法抽取到父类中,子类继承父类的方法,子类也可以根据自己的需要重写父类中的方法
* 2.可以使用接口规定子类的行为,使得都具有相同的行为
* */
public class 模板方法模式 {
    public static void main(String[] args) {

        LinkedHashSet<String> moduleSet = new LinkedHashSet<>();
        moduleSet.add("list");

        List<FilterModules> filterModules = FilterModules.fromKeys(moduleSet);

        for (FilterModules filter: filterModules) {
            System.out.println(filter.getK()+":"+filter.getQuery());
        }
    }
}
