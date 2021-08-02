package 第3工厂方法模式;

/**
 * @author yang
 * 2021年07月30日 17:44:00
 */
public class 工厂方法模式 {
    /*
    * 通过不同的工厂实例化不同的对象
    *
    * 简单工厂模式:在工厂类中包含了判断逻辑,如果增加新的算法,需要在服务端更改,添加新的分支时需要修改客户端,违背开放封闭原则
    *
    * 工厂方法模式:通过不同的工厂创建不同的实力类.添加新的分支,只需要增加新的类,客户端选择创建不同的对象即可
    *
    *
    *
    *
    * */

    //客户端代码
    public static void main(String[] args) {
        加法工厂 加法工厂 = new 加法工厂();
        Operation operation = 加法工厂.createOperation();
        operation.number1 = 3;
        operation.number2 = 4;
        System.out.println(operation.getResult());

    }
}
