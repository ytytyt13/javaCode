package 第5构建者模式;

/**
 * @author yang
 * 2021年08月02日 15:55:00
 */
public class 构建者模式 {
    /*
    * 将一个复杂的对象的构建与他的表示相分离,使得同样的构建过程可以创建不同的表示
    *
    * 1.使用一个接口规定构建的过程
    * 2.需要构建不同的类时,可以继承该接口,完成规定的方法,实现具体的构建过程
    * 3.通过一个监督者监督构建过程
    * */

    public static void main(String[] args) {
        构建者1 构建者1 = new 构建者1();
        产品 build = new builder(构建者1).build();
        build.show();
    }
}
