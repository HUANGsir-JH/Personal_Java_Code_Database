import java.util.Objects;
import java.util.TreeSet;

public class Tree_Set {
    public static void main(String[] args) {
        TreeSet<person> set =new TreeSet<>((o1, o2) -> {
            return o1.getAge()-o2.getAge();
            // lambda表达式
            // 按照年龄进行升序排序
        });

        person p = new person("张三", 20);
        person p1 = new person("李四", 30);
        person p2 = new person("王五", 40);
        person p3 = new person("张三", 20);
        set.add(p);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        for (person per : set) {
            System.out.println(per.getName()+" "+per.getAge());
        }
    }
}

/**
 * 可排序的set
 * 默认按照自然顺序排序，即ascii 码
 * 可以传入一个comparator，实现自定义排序，尤其是对自定义类进行排序
 */

class person{
    private String name;
    private int age;
    public person(String name, int age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}