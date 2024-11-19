import java.lang.reflect.Method;

public class MethodsDemo {
    public static void main(String[] args) throws Exception{
        Class<PersonDemo> personDemoClass = PersonDemo.class;
        
        // 获取所有的public方法，包括父类的public方法
        // getMethods()
        Method[] methods = personDemoClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        
        System.out.println("==========================");
        
        // 获取指定的public成员方法
        // getMethod(String name,Class<?>...parameters) 方法名，对应的参数（可能会有重载）
        // 调用方法 invoke(Object,args) 对象，参数列表
        Method setName = personDemoClass.getMethod("setName", String.class);
        PersonDemo person1 = personDemoClass.getConstructor().newInstance();
        setName.invoke(person1,"伍六七");
        System.out.println(person1);
        
        Method getName = personDemoClass.getMethod("getName");
        Object person1Name = getName.invoke(person1);
        System.out.println(person1Name);
        
        System.out.println("==========================");
        
        // 获取所有的成员方法，包括私有的，但是没有父类的方法2
        // getDeclaredMethods()
        Method[] declaredMethods = personDemoClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        
        System.out.println("==========================");
        
        // 获取指定的成员方法，包括私有的
        // getDeclaredMethod(String name,Class<?>...parameters)
        // 私有方法同样需要setAccessible(true)
        Method setAge = personDemoClass.getMethod("setAge", int.class);
        setAge.invoke(person1, 21);
        System.out.println(person1);
        
        System.out.println("==========================");
        
    }
}
