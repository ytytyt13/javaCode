package 第1简单工厂模式;

/**
 * @author yang
 * 2021年07月30日 14:45:00
 */
public class OperationFactory {
    public static Operation createOperate(String operate) {
        Operation oper = null;
        switch (operate){
            case "+":{
                oper = new OperationAdd();
                break;
            }
            case "-":{
                oper = new OperationSub();
                break;
            }
            default:{
                oper = null;
                break;
            }
        }
        return oper;
    }
}
