import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yang
 * 2021年06月03日 15:25:00
 */
public class test {
    public static void main(String[] args) {
        Set<String> w = new HashSet<>();
        w.add("乌鲁木齐");
        w.add("包车游");
        String q = "乌鲁木齐自由行";
        System.out.println(w.stream().anyMatch(word -> q.contains(word)));
    }
}
