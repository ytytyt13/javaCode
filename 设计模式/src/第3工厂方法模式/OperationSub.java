package 第3工厂方法模式;

/**
 * @author yang
 * 2021年07月30日 14:49:00
 */
public class OperationSub extends Operation {
    @Override
    public int getResult() {
        return super.number1 - super.number2;
    }
}
