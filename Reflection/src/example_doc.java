import lombok.Data;

/**
 * <h1>获取class对象</h1>
 * <ul>
 *     <li><pre><code>
 *         //通过类名,基本类型，引用类型
 *         //最常用
 *         Class<?> clazz = MyClass.class;
 *     </code></pre></li>
 *     <li><pre><code>
 *         //通过对象实例
 *         Class<?> clazz = obj.getClass();
 *     </code></pre></li>
 *     <li><pre><code>
 *         //通过静态方法
 *         //最通用，参数为string，可以和properties联用
 *         Class<?> clazz = Class.forName(String className);
 *         // className 可以是完整类名，也就是是包名加类名(类的全限定名)
 *     </code></pre></li>
 * </ul>
 *
 * <h1>常用的反射API</h1>
 * <ol>
 *     <li><code> getConstructors(): 获取所有公共构造方法</code></li>
 *     <li><code>getDeclaredConstructors(): 获取所有构造方法</code></li>
 *     <li><code>getMethods(): 获取所有公共方法</code></li>
 *     <li><code>getDeclaredMethods(): 获取所有方法</code></li>
 *     <li><code>getFields(): 获取所有公共字段</code></li>
 *     <li><code>getDeclaredFields(): 获取所有字段</code></li>
 *     <li><code>getSuperclass(): 获取父类</code></li>
 *     <li><code>setAccessible(true): 设置私有成员可访问</code></li>
 * </ol>
 *
 * <h1>常用类</h1>
 *<pre><code>
 *      // 用于演示的类
 *       public class TestClass {
 *           public void testMethod(String param1, int param2) throws Exception {
 *               // 方法实现
 *           }
 *       }
 * </code></pre>
 * <ol>
 *     <li>
 *         <p>Class类:描述类的类，可获取构造方法、字段、方法等</p>
 *         <code>Class<?> clazz = TestClass.class;</code><br>
 *         <pre><code>
 *             System.out.println("类名: " + clazz.getName());
 *             System.out.println("简单类名: " + clazz.getSimpleName());
 *             System.out.println("包名: " + clazz.getPackage().getName());
 *         </code></pre>
 *     </li>
 *     <li>
 *         <p>Constructor类：可用于创建实例对象</p>
 *         <code>Constructor<?> constructor = clazz.getConstructor();</code><br>
 *         <pre><code>
 *             System.out.println("构造方法名: " + constructor.getName());
 *             System.out.println("构造方法修饰符: " + Modifier.toString(constructor.getModifiers()));
 *         </code></pre>
 *     </li>
 *     <li>
 *         <p>Method类：可用于调用方法</p>
 *         <code> Method method = clazz.getMethod("testMethod", String.class, int.class);</code><br>
 *         <pre><code>
 *              System.out.println("方法名: " + method.getName());
 *              System.out.println("返回类型: " + method.getReturnType());
 *              System.out.println("参数类型: " + Arrays.toString(method.getParameterTypes()));
 *              System.out.println("异常类型: " + Arrays.toString(method.getExceptionTypes()));
 *         </code></pre>
 *     </li>
 *     <li>
 *         <p>Field类：可用于访问字段</p>
 *         <code>Field[] fields = clazz.getDeclaredFields();</code>
 *         <pre><code>
 *             for (Field field : fields) {
 *             System.out.println("字段名: " + field.getName());
 *             System.out.println("字段类型: " + field.getType());
 *             System.out.println("字段修饰符: " + Modifier.toString(field.getModifiers()));
 *          }
 *         </code></pre>
 *     </li>
 *     <li>
 *         <p>Modifier类：可用于获取修饰符</p>
 *         <code>int modifiers=clazz.getModifiers();</code>
 *         <pre><code>
 *             System.out.println("是否public: " + Modifier.isPublic(modifiers));
 *             System.out.println("是否final: " + Modifier.isFinal(modifiers));
 *             System.out.println("修饰符字符串: " + Modifier.toString(modifiers));
 *         </code></pre>
 *     </li>
 *     <li>
 *         <p>ClassLoader类</p>
 *         <pre><code>
 *             ClassLoader classLoader = clazz.getClassLoader();
 *             System.out.println("类加载器: " + classLoader);
 *         </code></pre>
 *     </li>
 *     <li>
 *         <p>Parameter类：可用于获取方法参数</p>
 *         <code>Parameter[] parameters = method.getParameters();</code>
 *         <pre><code>
 *             for (Parameter parameter : parameters) {
 *             System.out.println("参数名: " + parameter.getName());
 *             System.out.println("参数类型: " + parameter.getParameterizedType());
 *          }
 *          </code></pre>
 *     </li>
 * </ol>
 *
 * <h1>代码实例</h1>
 * <pre><code>
 *     public class ReflectionDemo {
 *     // 示例类
 *     public static class Person {
 *         private String name;
 *         private int age;
 *
 *         public Person() {}
 *
 *         public Person(String name, int age) {
 *             this.name = name;
 *             this.age = age;
 *         }
 *
 *         public void setName(String name) {
 *             this.name = name;
 *         }
 *
 *         private void showInfo() {
 *             System.out.println("Name: " + name + ", Age: " + age);
 *         }
 *     }
 *
 *     public static void main(String[] args) throws Exception {
 *         // 1. 获取Class对象的三种方式
 *         Class<?> class1 = Class.forName("ReflectionDemo$Person");
 *         Class<?> class2 = Person.class;
 *         Person p = new Person();
 *         Class<?> class3 = p.getClass();
 *
 *         // 2. 创建实例的两种方式
 *         // 使用newInstance()方法调用无参构造
 *         Person person1 = (Person) class1.newInstance();
 *
 *         // 获取指定构造方法并创建实例
 *         Constructor<?> constructor = class1.getConstructor(String.class, int.class);
 *         Person person2 = (Person) constructor.newInstance("张三", 25);
 *
 *         // 3. 获取所有构造方法
 *         Constructor<?>[] constructors = class1.getConstructors();
 *
 *         // 4. 获取所有方法（包括私有方法）
 *         Method[] methods = class1.getDeclaredMethods();
 *         for (Method method : methods) {
 *             System.out.println("方法名：" + method.getName());
 *         }
 *
 *         // 5. 获取指定方法
 *         Method setNameMethod = class1.getMethod("setName", String.class);
 *         // 调用方法
 *         setNameMethod.invoke(person1, "李四");
 *
 *         // 6. 调用私有方法
 *         Method showInfoMethod = class1.getDeclaredMethod("showInfo");
 *         showInfoMethod.setAccessible(true); // 设置可访问
 *         showInfoMethod.invoke(person1);
 *
 *         // 7. 获取所有字段（包括私有字段）
 *         Field[] fields = class1.getDeclaredFields();
 *         for (Field field : fields) {
 *             System.out.println("字段名：" + field.getName());
 *         }
 *
 *         // 8. 修改私有字段值
 *         Field nameField = class1.getDeclaredField("name");
 *         nameField.setAccessible(true);
 *         nameField.set(person1, "王五");
 *
 *         // 9. 获取类的修饰符
 *         int modifiers = class1.getModifiers();
 *         System.out.println("是否是public: " + Modifier.isPublic(modifiers));
 *
 *         // 10. 获取类的包信息
 *         Package pkg = class1.getPackage();
 *     }
 * }
 * </code></pre>
 */

public class example_doc {
    public static void main(String[] args) {
    
    }
}

@Data
class MyClass {
    private String name;
    private int age;
    //私有构造
    private MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public MyClass() {
    }
}

class getClass{
    public static void main(String[] args) throws ClassNotFoundException {
        get1();
    }
    public static void get1() throws ClassNotFoundException {
        MyClass myClass = new MyClass();
        Class<? extends MyClass> myClassClass = myClass.getClass();
        System.out.println("myClass: "+myClassClass);
        
        System.out.println("=========================");
        
        Class<? extends MyClass> myClassClass1 = MyClass.class;
        System.out.println("myClass1: "+myClassClass1);
        
        System.out.println("=========================");
        
        Class<?> myClass2 = Class.forName("MyClass");
        System.out.println("myClass2: "+myClass2);
        
    }
}
