
import java.util.ArrayList;
import java.util.List;


/**
 * @author yang
 * 2021年07月21日 11:53:00
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> d = new ArrayList<>();

        d.add("省份");
    d.add("城市");
            d.add("地区");
            d.add("国家");
        System.out.println(d.indexOf("地区"));
        System.out.println(d.indexOf("alal"));

    }
}
