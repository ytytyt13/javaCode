/**
 * @author yang
 * 2020年12月28日 18:28:00
 */
public class HungrySingleton {

    //1.将构造方法变为private
    //2.内部采用静态成员变量,在class加载进内存时,进行初始化
    //3.通过静态方法返回其实例
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {}
    public static HungrySingleton getInstance() {
        return instance;
    }
}
