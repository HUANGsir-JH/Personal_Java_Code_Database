import java.lang.reflect.Constructor;

/**
 * <pre><code>
 *     // 获取所有public构造方法
 *         Constructor<?>[] personDemoClassConstructors = personDemoClass.getConstructors();
 * </code></pre>
 * <pre><code>
 *     // 获取特定的public构造方法，如无参构造，有参构造
 *         // getConstructor(class...parameterTypes)
 *         //      如果获取的是空参，不需要写参数，否则需要写
 *         Constructor<PersonDemo> NoneParaConstructor = personDemoClass.getConstructor();
 * </code></pre>
 * <pre><code>
 *     // 获取有参的public构造,传入参数类型的类对象
 *         Constructor<PersonDemo> AllConstructor = personDemoClass.getConstructor(String.class, int.class);
 * </code></pre>
 * <pre><code>
 *     // 获取私有的构造方法
 *         // getDeclaredConstructors(): 获取所有构造方法，包括私有方法
 *         Constructor<?>[] dcs = personDemoClass.getDeclaredConstructors();
 * </code></pre>
 * <pre><code>
 *     // 获取指定的构造方法，包括私有的构造
 *         Constructor<PersonDemo> PrivateConstructor = personDemoClass.getDeclaredConstructor(String.class);
 *         System.out.println(PrivateConstructor);
 *             // 私有构造要进行实例化，必须先修改访问权限,否则报错
 *         PrivateConstructor.setAccessible(true); // 暴力反射
 * </code></pre>
 */
public class ConstructorsDemo {
    public static void main(String[] args) throws Exception{
        Class<PersonDemo> personDemoClass = PersonDemo.class;
        // 获取所有public构造方法
        Constructor<?>[] personDemoClassConstructors = personDemoClass.getConstructors();
        for (Constructor<?> personDemoClassConstructor : personDemoClassConstructors) {
            System.out.println(personDemoClassConstructor);
        }
        
        System.out.println("=========================");
        // 获取特定的public构造方法，如无参构造，有参构造
        // getConstructor(class...parameterTypes)
        //      如果获取的是空参，不需要写参数，否则需要写
        Constructor<PersonDemo> NoneParaConstructor = personDemoClass.getConstructor();
        System.out.println(NoneParaConstructor);
        PersonDemo NoneInstance = NoneParaConstructor.newInstance();
        System.out.println(NoneInstance);
        
        System.out.println("=========================");
        // 获取有参的public构造,传入参数类型的类对象
        Constructor<PersonDemo> AllConstructor = personDemoClass.getConstructor(String.class, int.class);
        System.out.println(AllConstructor);
        PersonDemo AllInstance = AllConstructor.newInstance("伍六七", 21);
        System.out.println(AllInstance);
        
        System.out.println("==========================");
        // 获取私有的构造方法
        // getDeclaredConstructors(): 获取所有构造方法，包括私有方法
        Constructor<?>[] dcs = personDemoClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : personDemoClass.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
        
        System.out.println("===========================");
        // 获取指定的构造方法，包括私有的构造
        Constructor<PersonDemo> PrivateConstructor = personDemoClass.getDeclaredConstructor(String.class);
        System.out.println(PrivateConstructor);
            // 私有构造要进行实例化，必须先修改访问权限,否则报错
        PrivateConstructor.setAccessible(true); // 暴力反射
        
        PersonDemo PriInstance = PrivateConstructor.newInstance("伍六七");
        System.out.println(PriInstance);
    }
}
