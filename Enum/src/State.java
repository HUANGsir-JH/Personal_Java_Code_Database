/**
 * <h1>自定义枚举类</h1>
 * <ul>
 *     <li>所有的枚举类都继承自java.lang.Enum</li>
 *     <li>所有的枚举类都是static final的,但是定义的时候不要写出来，会报错。最后记得加上分号</li>
 *     <li>所有的枚举类都是线程安全的</li>
 *     <li>枚举类名字建议首字母大写，属性建议全大写</li>
 *     <li>每一个枚举值都是当前枚举类的对象</li>
 * </ul>
 * <h1>使用方法</h1>
 * <ol>
 *     <li>使用类的对象调用</li>
 *     <li>使用类名调用</li>
 * </ol>
 * <h1>枚举类中其他的成员</h1>
 * <ul>
 *     <li>构造函数：默认是private，不允许自定义为public</li>
 * </ul>
 * <h1>枚举的方法/h1>
 * <ul>
 *      <li><code>String toString()</code></li>
 *      <p>返回枚举值的名字</p>
 *      <li><code>values()</code></li>
 *      <p>返回所有的枚举值</p>
 *      <li><code>valuesOf(String str)</code></li>
 *      <p>将一个字符串转化为枚举类型</p>
 * </ul>
 */
public enum State {
    UP("上"),
    DOWN("下"),
    LEFT("左"),
    RIGHT("右");
    // 相当于给每个常量进行了含义的介绍
    private String name;
    State(String name) {
        this.name=name;
    }
    
    public String getName() {
        return name;
    }
}
