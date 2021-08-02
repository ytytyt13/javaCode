package 第3工厂方法模式;

/**
 * @author yang
 * 2021年08月02日 14:46:00
 */
public class 加法工厂 implements 工厂接口 {
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
