import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @author yang
 * 2021年03月01日 10:13:00
 */

enum Color {
    //红色
    RED{
        @Override
        public void getName() {
            System.out.println("RED");
        }
    },
    //绿色
    BLUE{
        @Override
        public void getName() {
            System.out.println("BLUE");
        }
    };
    public void getName(){
        System.out.println("aaa");
    }
}

public class 数据结构 {
    public static void main(String[] args) {
        //数组
        System.out.println("数组");
        int[] a= {1,2,3};
        //System.out.println(a[-1]);

        //List
        System.out.println("list");
        ArrayList<Integer> objects1 = new ArrayList<>();
        objects1.add(1);
        //ArrayList<Integer> clone = (ArrayList<Integer>)objects1.clone();
        //System.out.println(clone.get(0));

        //Integer[] objects3 = (Integer[])objects1.toArray();
        Integer[] objects2 = objects1.toArray(new Integer[objects1.size()]);
        System.out.println("array list");

        //LinkedList
        LinkedList<Integer> link = new LinkedList<Integer>();
        link.offerLast(1);
        link.offerFirst(2);

        Integer[] arr = {1,2,3};

        //数组转链表
        List<Integer> list2 = new ArrayList<Integer>(arr.length);
        list2.addAll(Arrays.asList(arr));
        Collections.addAll(list2, arr);
        for (Integer integer : list2) {
            System.out.println(integer);
        }

        //vector
        new Vector();

        //Stack
        new Stack();

        //Map
        Map<String, String> map = new HashMap<String, String>();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Set<String> strings = map.keySet();
        Collection<String> values = map.values();

        new CopyOnWriteArrayList();

        new Vector();
        new Stack();


        //Map();
        //AbstractMap;
        //SortedMap
        new HashMap();
        new ConcurrentHashMap<>();
        new Hashtable<>();
        new TreeMap();
        new LinkedHashMap<>();
        new HashSet();



        List<String> objects = new ArrayList<>();
        objects.add("aa");
        objects.add("bb");
        objects.add("cc");
        objects.add("dd");
        objects.remove("aa");
        System.out.println(objects);

        //ClassLoader

        //线程安全类
        Collections.synchronizedList(objects);
        new CopyOnWriteArrayList<String>();


        Collections.synchronizedSet(new HashSet<>());
        new CopyOnWriteArraySet<String>();

        Collections.synchronizedMap(new HashMap<>());
        new ConcurrentHashMap<>();


        System.out.println("---------------------------");

        AAA aa = new AAAimpl1();
        aa.test1();
        aa = new AAAimpl2();
        aa.test1();

        System.out.println("*********************");

        List<Integer> arr1 = new ArrayList<>(10);
        System.out.println(arr1.size());
        arr1.set(1,10);
        System.out.println(arr1.get(1));

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "玩法信息表"+formatter.format(date)+".xls";
        System.out.println(fileName);

        String s = "25.0";
        double res = Double.valueOf(s)/5.0;
        System.out.println(String.valueOf(res));

    }
}

