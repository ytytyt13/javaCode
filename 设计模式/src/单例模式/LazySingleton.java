package 单例模式;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月02日 15:36:00
 */
public class LazySingleton {

    private static LazySingleton instance;
    private LazySingleton(){}
    private static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
