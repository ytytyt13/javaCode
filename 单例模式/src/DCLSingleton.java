/**
 * @author yang
 * 2020年12月28日 19:32:00
 */
public class DCLSingleton {
   private volatile static DCLSingleton instance = null;
   private DCLSingleton(){}

   public static DCLSingleton getInstance() {
       if (instance == null) {
          synchronized (DCLSingleton.class) {
              if (instance == null) {
                  instance = new DCLSingleton();
              }
          }
       }
       return instance;
   }
}
