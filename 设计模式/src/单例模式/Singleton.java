package 单例模式;

/**
 * @author yang
 * 2020年12月28日 17:55:00
 */
public class Singleton {
    private Singleton instance = null;
    private Singleton() {}
    public Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


