/**
 * @author yang
 * 2021年03月02日 16:11:00
 */
public class jstack {

    //频繁gc
    public static void main(String[] args) {
        int i=0;
        while(true) {
            User user = new User();
            user.setAge(i++);
            System.out.println(i);
        }
    }
}
