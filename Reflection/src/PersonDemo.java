import java.util.Objects;

public class PersonDemo {
    private String name;
    private int age;
    public float salary=3000;
    
    public PersonDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public PersonDemo(){}
    
    // 私有构造name
    private PersonDemo(String n){
        name=n;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void noneParameter(){
        System.out.println("none");
    }
    
    @Override
    public String toString() {
        return "PersonDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDemo that = (PersonDemo) o;
        return age == that.age && Objects.equals(name, that.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
