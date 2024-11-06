import java.io.*;

public class serialization {
    public static void main(String[] args) {
    
    }
}

/**
 * 1.作用：
 *         将对象以流的形式写入到文件中，或者从文件中读取对象
 *         比如说游戏数据的保存等
 * 2. 流的形式
 *         1. 以字节流的形式写入文件，或者从文件中读取字节流
 *         2. 序列化 -> ObjectOutputStream -> 写对象
 *              -> 构造：ObjectOutputStream(OutputStream out)
 *              -> 方法：writeObject(Object obj)
 *         3. 反序列化 -> ObjectInputStream -> 读对象
 *              -> 构造：ObjectInputStream(InputStream in)
 *              -> 方法：readObject()
 * 3. 注意：
 *           1. 序列化的对象必须实现Serializable接口，只是一个标记接口，没有方法
 *           2. 序列化的对象必须是可序列化的，如果类包含的成员变量是对象类型，
 *              那么这些成员变量也必须是可序列化的。否则，
 *              需要将这些成员变量标记为  transient ，以便在序列化过程中忽略它们。
 *           3. 在 Java 中，serialVersionUID 是一个唯一标识序列化类的版本的静态字段。
 *              它用于在序列化和反序列化过程中验证类的一致性。
 *              如果类的 serialVersionUID 值与序列化对象的 serialVersionUID 值不匹配，
 *              会抛出 InvalidClassException 异常。如果不显式定义 serialVersionUID，
 *              Java 编译器会根据类的结构自动生成一个 serialVersionUID 值
 *              但是这样可读性会降低
 */


class assassin implements Serializable{ // assassin:刺客

    private static final long serialVersionID = 1L;
    // 一个序列化ID
    private String name;
    private int age;
    
    public assassin(String name, int age) {
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
        return "assassin{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Serialization{
    static assassin assassin=new assassin("伍六七", 18);
    static File ser_file=new File("D:\\IDEA_Java\\Java_Learning\\Serialization_Deserialization\\ser_assassin.ser");
    public static void main(String[] args) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(ser_file))){
            oos.writeObject(assassin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class DeSerialization{
    static File ser_file=new File("D:\\IDEA_Java\\Java_Learning\\Serialization_Deserialization\\ser_assassin.ser");
    public static void main(String[] args) {
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(ser_file))){
            assassin assassin=(assassin) ois.readObject();
//          ois.readObject()方法会返回一个Object类型的对象，
//          然后通过强制类型转换将其转换为assassin类型的对象
            System.out.println(assassin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
