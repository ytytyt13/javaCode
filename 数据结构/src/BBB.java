
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * @author yang
 * 2021年03月10日 12:01:00
 */
public class BBB {
    public static void main(String[] args) {
        TreeSet<String> moduleSet = new TreeSet<>();
        moduleSet.add("1");
        moduleSet.add("2");
        moduleSet.add("3");

        SortedMap<String, String> params = new TreeMap<>();
        params.put("2","a,b,c");

        SortedMap<String, String[]> requestParams = new TreeMap<>();

        getIncludeModuleMap(moduleSet, params, requestParams);

        System.out.println(requestParams.toString());

        List<String> aa = new ArrayList<>();
        aa.add("1");
        aa.add("2");
        aa.add("3");

        aa.forEach(a->a="a");

        System.out.println(aa.toString());

    }

    private static void getIncludeModuleMap(SortedSet<String> moduleSet, SortedMap<String, String> params, SortedMap<String, String[]> requestParams) {
        System.out.println(params.toString());
        ArrayList<String> strings = new ArrayList<>();
        moduleSet.stream().peek(module -> {
            System.out.println("a");
            strings.add(module);
            if(params.containsKey(module)) {
                requestParams.put("modules." + module + ".include",new String[]{params.get(module)});
            }
        });
        System.out.println(strings.toString());
    }
}
