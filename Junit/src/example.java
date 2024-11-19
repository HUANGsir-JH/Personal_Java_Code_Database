import org.junit.Test;

public class example { //只有public类才能被Junit识别为测试类。
    public static void main(String[] args) {
    
    }
    @Test
    public void add(){
        System.out.println("test: "+"1+2 = 3" );
    }
    @Test
    public void sub(){
        System.out.println("test: "+"1-2 = -1" );
    }
}

/**
 * JUnit 4 常见工具集 Javadoc 文档
 *
 * <p>本类包含了 JUnit 4 的常用注解、断言方法、异常测试等内容。</p>
 * <p><strong>只有public类才能被Junit识别为测试类。</strong></p>
 *
 * <h2>1. 常见注解</h2>
 * <ul>
 *     <li>{@link org.junit.Test} - 标记测试方法。</li>
 *     <p>@Test不能修饰：
 *          <ul>
 *              <li>static方法</li>
 *              <li>带参数的方法</li>
 *              <li>带返回值的方法</li>
 *          </ul>
 *     </p>
 *     <li>{@link org.junit.Before} - 在每个测试方法之前执行。有多少个@Test方法就执行多少次，一般用于初始化数据</li>
 *     <li>{@link org.junit.After} - 在每个测试方法之后执行。同理于Before，一般用于清理数据，释放资源</li>
 *     <li>{@link org.junit.BeforeClass} - 在所有测试方法之前执行，必须为静态方法。只执行一次</li>
 *     <li>{@link org.junit.AfterClass} - 在所有测试方法之后执行，必须为静态方法。只执行一次</li>
 *     <li>{@link org.junit.Ignore} - 忽略测试方法。</li>
 *     <li>{@link org.junit.Assert} - 提供了断言方法用于验证测试结果。</li>
 * </ul>
 *
 * <h2>2. 常见断言方法</h2>
 * <ul>
 *     <li>{@code void assertEquals(expected, actual)} - 判断两个值是否相等。</li>
 *     <li>{@code void assertNotEquals(expected, actual)} - 判断两个值是否不相等。</li>
 *     <li>{@code void assertTrue(condition)} - 判断条件是否为 true。</li>
 *     <li>{@code void assertFalse(condition)} - 判断条件是否为 false。</li>
 *     <li>{@code void assertNull(object)} - 判断对象是否为 null。</li>
 *     <li>{@code void assertNotNull(object)} - 判断对象是否不为 null。</li>
 *     <li>{@code void fail()} - 手动使测试失败。</li>
 * </ul>
 *
 * <h2>3. 异常测试</h2>
 * <p>使用 {@link org.junit.Test} 注解的 {@code expected} 属性测试异常。</p>
 *
 * <h3>示例：</h3>
 * <pre>{@code
 * @Test(expected = NumberFormatException.class)
 * public void testException() {
 *     Integer.parseInt("invalid");
 * }
 * }</pre>
 *
 * <h2>4. 超时测试</h2>
 * <p>使用 {@link org.junit.Test} 注解的 {@code timeout} 属性测试超时。</p>
 *
 * <h3>示例：</h3>
 * <pre>{@code
 * @Test(timeout = 1000)
 * public void testTimeout() throws InterruptedException {
 *     Thread.sleep(500);
 * }
 * }</pre>
 *
 * <h2>5. 示例类</h2>
 * <p>包含常用注解和断言方法的完整示例类。</p>
 * <pre>{@code
 * import org.junit.*;
 *
 * public class ExampleTest {
 *
 *     @BeforeClass
 *     public static void initAll() {
 *         System.out.println("Before all tests");
 *     }
 *
 *     @Before
 *     public void init() {
 *         System.out.println("Before each test");
 *     }
 *
 *     @Test
 *     public void testAddition() {
 *         Assert.assertEquals(2, 1 + 1);
 *     }
 *
 *     @Test
 *     @Ignore("This test is ignored")
 *     public void testIgnored() {
 *         Assert.fail("This test should be skipped");
 *     }
 *
 *     @After
 *     public void tearDown() {
 *         System.out.println("After each test");
 *     }
 *
 *     @AfterClass
 *     public static void tearDownAll() {
 *         System.out.println("After all tests");
 *     }
 * }
 * }</pre>
 *
 * <h2>6. Maven 配置</h2>
 * <pre>{@code
 * <dependency>
 *     <groupId>junit</groupId>
 *     <artifactId>junit</artifactId>
 *     <version>4.13.2</version>
 *     <scope>test</scope>
 * </dependency>
 * }</pre>
 *
 * <h2>7. 总结</h2>
 * <p>JUnit 4 是 Java 开发者常用的单元测试框架，支持简单的测试注解和断言方法，能够帮助开发者编写可靠的测试。</p>
 */
class junit_example{

}
