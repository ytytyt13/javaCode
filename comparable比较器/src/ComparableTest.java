import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author yang
 * 2021年01月12日 11:33:00
 */
public class ComparableTest {
    public static void main(String[] args) {
        /*
        * 通过实现compareble接口，可以调用Collections.sort或者Arrays.sort()方法进行对象的排序
        * */
        Person[] people=new Person[]{new Person("xujian", 20),new Person("xiewei", 10)};
        System.out.println("排序前");
        for (Person person : people)
        {
            System.out.print(person.getName()+":"+person.getAge());
        }
        //Arrays.sort(people);
        Collections.sort(Arrays.asList(people));
        System.out.println("\n排序后");
        for (Person person : people)
        {
            System.out.println(person.getName()+":"+person.getAge());
        }

        System.out.println("******************************************************");
        /*
        * 如果没有实现comparable接口，需要实现compartor接口，重写compare方法
        * */
        class PersonCompartor implements Comparator<Person1>
        {
            @Override
            public int compare(Person1 o1, Person1 o2)
            {
                return o1.getAge()-o2.getAge();
            }
        }
        Person1[] people1=new Person1[]{new Person1("xujian", 20),new Person1("xiewei", 10)};
        System.out.println("排序前");
        for (Person1 person : people1)
        {
            System.out.print(person.getName()+":"+person.getAge());
        }
        //Arrays.sort(people1,(o1,o2)->{return o1.getAge()-o2.getAge();});
        Collections.sort(Arrays.asList(people1),new PersonCompartor());
        System.out.println("\n排序后");
        for (Person1 person : people1)
        {
            System.out.print(person.getName()+":"+person.getAge());
        }




    }
}
