package 第4模板方法模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * 2021年08月02日 14:57:00
 */
enum FilterModules implements module<String,String> {

    LIST("list","list"){
        @Override
        public String getQuery() {
            return "departre"+"arrive";
        }
    },
    modules2("test2key","test2value");

    private String key;
    private String value;

    FilterModules(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getK() {
        return this.key;
    }

    @Override
    public String getV() {
        return this.value;
    }

    @Override
    public String getQuery() {
        return key;
    }

    public static List<FilterModules> fromKeys(Iterable<String> keys) {
        List<FilterModules> ret = new ArrayList<FilterModules>();
        for (String key : keys) {
            for (FilterModules m : FilterModules.values()) {
                if (m.getV().equalsIgnoreCase(key)) {
                    ret.add(m);
                }
            }
        }
        return ret;
    }


}

