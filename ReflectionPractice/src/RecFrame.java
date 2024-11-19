import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class RecFrame {
    public static void main(String[] args) throws Exception{
        // 1.创建properties集合
        Properties properties = new Properties();
        // 2.读取配置文件，添加键值对
        //      配置文件单独放在resources目录中，并且将目录标记为资源根目录
        InputStream resourceAsStream = RecFrame.class.getClassLoader().getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);
        // System.out.println(properties);
        
        // 3.根据解析出来的className创建对象
        // 4.根据解析出来的methodName调用对象的方法
        
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        
        Class<?> aClass = Class.forName(className);
        Object o = aClass.getConstructor().newInstance();
        Method method = aClass.getMethod(methodName);
        method.invoke(o);
        
    }

}
