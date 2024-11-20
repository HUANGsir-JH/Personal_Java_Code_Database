import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <h1>自定义注解</h1>
 * <ol>
 *     <li><code>@Retention(RetentionPolicy.RUNTIME)</code></li>
 *     <p>作用：指定注解的生命周期。</p>
 *     <ul>
 *         <li><code>RetentionPolicy.SOURCE</code></li>
 *         <p>作用：仅保留在源文件中，不会在class文件中存在。</p>
 *         <li><code>RetentionPolicy.CLASS</code></li>
 *         <p>作用：仅保留在class文件中，不会在源文件中存在。</p>
 *         <li><code>RetentionPolicy.RUNTIME</code></li>
 *         <p>作用：保留在class文件和源文件中，可通过反射获取。</p>
 *     </ul>
 *     <li><code>@Target(ElementType.METHOD)</code></li>
 *     <p>作用：指定注解的作用目标、使用位置。</p>
 *     <ul>
 *         <li><code>ElementType.METHOD</code></li>
 *         <p>作用：方法上使用。</p>
 *         <li><code>ElementType.FIELD</code></li>
 *         <p>作用：字段上使用。</p>
 *         <li><code>ElementType.LOCAL_VARIABLE</code></li>
 *         <p>作用：局部变量上使用。</p>
 *         <li><code>ElementType.ANNOTATION_TYPE</code></li>
 *         <p>作用：注解上使用。</p>
 *         <li><code>ElementType.PACKAGE</code></li>
 *         <p>作用：包上使用。</p>
 *         <li><code>ElementType.CONSTRUCTOR</code></li>
 *         <p>作用：构造函数上使用。</p>
 *         <li><code>ElementType.PARAMETER</code></li>
 *         <p>作用：方法参数上使用。</p>
 *         <li><code>ElementType.TYPE</code></li>
 *         <p>作用：类、接口(包括注解类型)或枚举上使用。</p>
 *         <li><code>ElementType.TYPE_PARAMETER</code></li>
 *         <p>作用：类型参数上使用。</p>
 *     </ul>
 * </ol>
 * <h1>属性定义</h1>
 * <ol>
 *     <li><code>格式：数据类型 属性名()。</code></li>
 *     <li><code>默认值使用 default 关键字。</code></li>
 * </ol>
 * <p>数据类型 属性名()  ->此属性没有默认值，使用的时候必须赋值。</p>
 * <p>数据类型 属性名() = 值  ->此属性有默认值，必要时可以二次修改</p>
 * <h1>可以被定义的属性：</h1>
 * <ol>
 *     <li>八种基本类型</li>
 *     <li>String, class类型, enum类型, annotation类型</li>
 *     <li>上述类型的一维数组</li>
 * </ol>
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface selfAnnotation {
    String bookName();
    String[] authors();
    int count() default 10;
    int price();
}

