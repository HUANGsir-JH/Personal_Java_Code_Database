import java.util.Objects;
import java.util.TreeMap;

public class Tree_Map {
    public static void main(String[] args) {
        TreeMap<staff,Integer> map=new TreeMap<>((o1,o2)->{
            return o1.getAge()-o2.getAge();
        });

        staff s1 = new staff("张三", 20);
        staff s2 = new staff("李四", 30);
        staff s3 = new staff("王五", 40);
        staff s4 = new staff("张三", 20);
        map.put(s1, 1);
        map.put(s2, 2);
        map.put(s3, 3);
        map.put(s4, 4);
        System.out.println(map);
    }
}

/**
 * 对key进行排序
 * 同样是传入一个比较器
 * 对于自定义的类型必须传入比较规则
 * 否则会报错
 */

class staff{
    private String name;
    private int age;
    public staff(String name, int age) {
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
        return "staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        staff staff = (staff) o;
        return age == staff.age && Objects.equals(name, staff.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
