/**
 * @author yang
 * 2021年01月12日 11:35:00
 */
public class Person implements Comparable<Person>
{
    private String name;
    private int age;
    public Person(String name, int age)
    {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
    return age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
}
