import java.util.HashMap;
import java.util.Objects;

public class map {
    public static void main(String[] args) {
        HashMap<person, String> map = new HashMap<>();
        person p = new person("张三", 20);
        map.put(p,"一");
        person p1= new person("李四", 30);
        map.put(p1,"二");
        person p2= new person("王五", 40);
        map.put(p2,"三");
        person p3=new person("张三", 20);
        map.put(p3,"一");
        System.out.println(map);// 自定义对象作为键值时，如果不重写equals和hashcode方法，
        // 会出现重复的情况，这是因为不重写时比较的是对象的地址，而重写后比较的是对象的内容，所以会出现重复的情况
        // hashset也是同样的道理
    }
}

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
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    // alt+Fn+insert 直接生成就行
    // 重写equals和hashcode方法
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
