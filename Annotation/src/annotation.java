/**
 * <h1>注解的使用</h1>
 * <ol>
 *     <li><p>注解的使用简单讲就是给属性赋值</p></li>
 *     <li><p>使用的位置上：方法，变量，类的前面</p></li>
 *     <li><p>使用的格式：<pre>@注解名(属性名=属性值,属性名=属性值,...)<br>如果是数组的话可以这样:@注解名(属性名={值1,值2,值3...})
 *     </pre></p></li>
 * </ol>
 */
@selfAnnotation(bookName = "Java编程思想", authors = {"Bruce Nickel","John von Neumann"}, price = 30)
public class annotation {
    public static void main(String[] args) {
    
    }
}

/**
 * <h1>测试类</h1>
 * <p>此类演示了在Java中使用自定义注解。</p>
 * <h2>方法</h2>
 * <ul>
 *     <li><code>isAnnotationPresent(Class&lt;? extends Annotation&gt; annotationClass)</code></li>
 *     <p>检查指定的注解是否存在于此元素上。</p>
 *     <p>如果注解存在，返回<code>true</code>，否则返回<code>false</code>。</p>
 *     <li><code>getAnnotation(Class&lt;T&gt; annotationClass)</code></li>
 *     <p>如果此元素存在指定类型的注解，则返回该注解，否则返回<code>null</code>。</p>
 * </ul>
 */
class test01{
    public static void main(String[] args) {
        Class<annotation> annotationClass = annotation.class;
        boolean b = annotationClass.isAnnotationPresent(selfAnnotation.class);
        if (b) {
            selfAnnotation selfAnnotation = annotationClass.getAnnotation(selfAnnotation.class);
            System.out.println(selfAnnotation.bookName());
            System.out.println(selfAnnotation.authors()[0]);
            System.out.println(selfAnnotation.count());
            System.out.println(selfAnnotation.price());
        }
    }
}

/**
 * <h1>Java内置注解</h1>
 * <ol>
 *     <li><code>@Override</code></li>
 *     <p>作用：表明当前方法重写了父类或接口中的方法。</p>
 *     <p>编译器行为：如果方法没有正确重写，编译器会报错。</p>
 *     <li><code>@Deprecated</code></li>
 *     <p>作用：表明当前方法过时，已被弃用。</p>
 *     <p>编译器行为：如果方法使用了@Deprecated注解，编译器会报警告。</p>
 *     <li><code>@SuppressWarnings</code></li>
 *     <p>作用：禁用编译器的警告。</p>
 *     <p>编译器行为：如果方法使用了@SuppressWarnings注解，编译器会忽略对应的警告。</p>
 *     <pre><code>
 *         // @SuppressWarnings("unchecked")  -> 忽略未经检查的操作警告。
 *         // @SuppressWarnings("all")  -> 禁用所有警告。
 *         // @SuppressWarnings("deprecation")  -> 禁用过时方法警告。
 *     </code></pre>
 *     <li><code>@SafeVarargs</code></li>
 *     <p>作用：表明方法的可变参数是安全的。</p>
 *     <p>编译器行为：如果方法使用了@SafeVarargs注解，编译器会忽略对应的警告。</p>
 *     <p>适用场景：静态方法、final 方法，或构造函数。</p>
 *     <li><code>@FunctionalInterface</code></li>
 *     <p>作用：表明当前类是函数式接口。</p>
 *     <p>编译器行为：如果接口有多于一个抽象方法，编译器会报错。</p>
 * </ol>
 * <h1>Java元注解</h1>
 * <ol>
 *     <li><code>@Retention</code></li>
 *     <p>作用：指定注解的生命周期。</p>
 *     <ul>
 *         <li>RetentionPolicy.SOURCE：仅在源码中存在，编译后丢弃。</li>
 *         <li>RetentionPolicy.CLASS：在字节码中存在，运行时不可见（默认）。</li>
 *         <li>RetentionPolicy.RUNTIME：在运行时可通过反射访问。</li>
 *     </ul>
 *     <pre><code>
 *         // @Retention(RetentionPolicy.RUNTIME)
 *         public @interface MyAnnotation {}
 *     </code></pre>
 *     <li><code>@Target</code></li>
 *     <p>作用：指定注解可应用的程序元素。</p>
 *     <ul>
 *         <li>ElementType.TYPE：类、接口或枚举。</li>
 *         <li>ElementType.FIELD：字段。</li>
 *         <li>ElementType.METHOD：方法。</li>
 *         <li>ElementType.CONSTRUCTOR：构造函数。</li>
 *         <li>ElementType.PARAMETER：方法参数。</li>
 *     </ul>
 *     <pre><code>
 *         // @Target({ElementType.METHOD, ElementType.FIELD})
 *            public @interface MyAnnotation {}
 *     </code></pre>
 *     <li><code>@Documented</code></li>
 *     <p>作用：指定注解是否包含在生成的 Javadoc 中。</p>
 *     <pre><code>
 *         // @Documented
 *            public @interface MyAnnotation {}
 *     </code></pre>
 *     <li><code>@Inherited</code></li>
 *     <p>作用：允许子类继承父类的注解。</p>
 *     <pre><code>
 *         // @Inherited
 *            public @interface MyAnnotation {}
 *     </code></pre>
 * </ol>
 */
class test{

}