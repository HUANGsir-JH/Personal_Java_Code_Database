import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class property {
    public static void main(String[] args) {
    
    }
}

/**
 * 1.  Properties 继承自hashtable
 *      无序，无索引，key唯一，线程安全，key和value默认是string
 *      用法: setProperty(key, value) -> 存键值对
 *           getProperty(key) -> 根据key获取值
 *           stringPropertyNames() -> 获取所有key,存放到set集合
 *           load(inputStream in) -> 将流中数据加载到Properties集合中
 *           store(OutputStream out, String comments)->用于将修改后的 Properties 对象保存到文件中。
 *                                              comments 参数可以用来添加注释信息，写入到配置文件的头部。
 *           store(Writer writer, String comments)
 *
 * 配合配置文件使用
 *      创建配置文件：模块->file->取名xxx.properties
 *      在文件中写配置数据
 *          1.key和value都是key=value的形式
 *          2.key和value都是string，但是不要加引号
 *          3.每个键值对写完需要换行在写
 *          4.键值对之间建议不要有空格
 *          5.键值对建议不要用中文，会乱码
 *
 * 我们不能把很多的硬数据放到源码当中，比如用户名和密码等数据，因为将来我们有更换这些数据的时候
 * 如果一换，我们就需要去源码中修改，以来不方便维护，而来类与类之间都有联系，有可能改一下
 * 代码就崩溃了。所以需要将这些数据提取出来作为配置文件，改的时候字节去文件中改，源码不需要动
 */

class basicPropertiesDemo {
    public static void main(String[] args) {
        Properties properties=new Properties();
        properties.setProperty("key1","五六七");
        properties.setProperty("key2", "梅花十三");
        
        Set<String> set=properties.stringPropertyNames();
        for(String key:set){
            System.out.println(properties.getProperty(key));
        }
    }
}

class loadPropertiesDemo {
    public static void main(String[] args) {
        Properties properties=new Properties();
        File config=new File("D:\\IDEA_Java\\Java_Learning\\Properties_IO\\jdbc.properties");
        try {
            properties.load(new FileInputStream(config));
            Set<String> set=properties.stringPropertyNames();
            System.out.println(set);
            for (String s : set) {
                System.out.println(s+"="+properties.getProperty(s));
            }
            // 可以用setProperty(key,value)修改配置文件，或者添加性的配置
            // 修改之后用store保存
            // // 2. 修改配置属性
            //        props.setProperty("password", "67890"); // 修改已有属性
            //        props.setProperty("timeout", "30");     // 添加新属性
            //
            //        // 3. 将修改后的配置保存到文件
            //        try (FileOutputStream out = new FileOutputStream(filePath)) {
            //            props.store(out, "Updated configuration");
            //            System.out.println("Properties updated and saved.");
            //        } catch (IOException e) {
            //            e.printStackTrace();
            //        }
            //    }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}