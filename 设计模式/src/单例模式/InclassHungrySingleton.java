package 单例模式;

/**
 * @author yang
 * 2020年12月28日 18:33:00
 */
public class InclassHungrySingleton {
    //1.内部静态类的方式,只有当调用内部静态类的静态方法时,才会实例化对像
    private static class SingletonHolder{
        private static InclassHungrySingleton instance = new InclassHungrySingleton();
    }
    private InclassHungrySingleton() {}

    public static InclassHungrySingleton getInstance() {
        return SingletonHolder.instance;
    }
}
