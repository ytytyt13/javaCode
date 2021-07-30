package 第1简单工厂模式;

/**
 * @author yang
 * 2021年07月30日 14:31:00
 */
public class 简单工厂模式 {
    //简单工厂模式
    /*
    * 特点:根据传入的参数选择实例化不同对象.方便扩展
    * 例如计算器中可以根据传入的运算符选择实例化不同的运算类,这样在下次需要增加运算符时,只需要新加入运算类和switch分支即可
    *
    *
    * */
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 6;

        //根据传入参数选择实例化不同的实现类
        String oper = "-";
        Operation operate = OperationFactory.createOperate(oper);
        operate.number1 = num1;
        operate.number2 = num2;

        System.out.println(operate.getResult());
    }

}
