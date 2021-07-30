package 第1简单工厂模式;

/**
 * @author yang
 * 2021年07月30日 14:47:00
 */
public class OperationAdd extends Operation {
    @Override
    public int getResult() {
        return super.number1+super.number2;
    }
}
