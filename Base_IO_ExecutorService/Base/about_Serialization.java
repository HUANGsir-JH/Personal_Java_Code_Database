package Base;

import java.io.*;

// 序列化
public class about_Serialization {
    public static void main(String[] args) {
    
    }
}


class _Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // 确保类版本的一致性
    private String name;
    private int age;
    
    public _Person(String name, int age) {
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
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// 序列化
class serializable_demo{
    public static void main(String[] args) {
        String filepath="D:\\IDEA_Java\\Java_Learning\\src\\person.ser";
        _Person person = new _Person("张三", 20);
        try (FileOutputStream fileOut = new FileOutputStream(filepath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ) {
            out.writeObject(person); // 序列化对象
            System.out.println("序列化完成，文件已创建: " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 反序列化
class deserializable_demo{
    public static void main(String[] args) {
        String filepath="D:\\IDEA_Java\\Java_Learning\\src\\person.ser";
        _Person person0 = null;
        try (FileInputStream fileIn = new FileInputStream(filepath);
             ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            person0 = (_Person) in.readObject(); // 反序列化
            System.out.println("反序列化完成： " + person0);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
