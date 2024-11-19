import java.util.ArrayList;
import java.util.stream.Stream;

public class stream_flow {
    public static void main(String[] args) {
    
    }
}

// stream流指的不是IO流，而是一种编程方式，“流式编程”
/**
 * <h1>Stream API 使用指南</h1>
 * <p>Java 8 引入的 Stream API 提供了对集合数据的高效操作，支持函数式编程。
 * Stream API 主要用于对集合、数组等数据结构中的元素进行声明式操作。</p>
 * <h2>主要特点：</h2>
 * <ul>
 *   <li>惰性求值：中间操作是惰性执行的，只有调用终端操作时才会执行。</li>
 *   <li>链式调用：多个操作可以链式调用，简化代码。</li>
 *   <li>并行处理：支持并行流，提升性能。</li>
 * </ul>
 * <h2>Stream 的创建方式：</h2>
 * <ul>
 *   <li>通过集合：{@code stream = list.stream()}</li>
 *   <li>通过数组：{@code stream = Arrays.stream(array)}</li>
 *   <li>通过 Stream 静态方法：{@code stream = Stream.of(1, 2, 3)}</li>
 *   <li>通过无限流：{@code stream = Stream.generate(Math::random)}</li>
 * </ul>
 *
 * <h2>常见中间操作：</h2>
 *
 * <h3>1. filter()</h3>
 * <pre>{@code
 * List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
 * names.stream()
 *      .filter(name -> name.startsWith("A"))
 *      .forEach(System.out::println); // 输出：Alice
 * }</pre>
 * <p>过滤符合条件的元素。</p>
 *
 * <h3>2. map()</h3>
 * <pre>{@code
 * List<String> words = Arrays.asList("hello", "world");
 * words.stream()
 *      .map(String::toUpperCase)
 *      .forEach(System.out::println); // 输出：HELLO WORLD
 * }</pre>
 * <p>对每个元素应用映射函数，返回新的 Stream。</p>
 *
 * <h3>3. sorted()</h3>
 * <pre>{@code
 * Stream.of(3, 1, 4, 2)
 *       .sorted()
 *       .forEach(System.out::println); // 输出：1 2 3 4
 * }</pre>
 * <p>对元素进行排序。</p>
 *
 * <h3>4. distinct()</h3>
 * <pre>{@code
 * Stream.of(1, 2, 2, 3)
 *       .distinct()
 *       .forEach(System.out::println); // 输出：1 2 3
 * }</pre>
 * <p>去重操作。</p>
 * <p>自定义的数据类型需要重写hashcode和equals</p>
 *
 * <h3>5. limit() 和 skip()</h3>
 * <pre>{@code
 * Stream.of(1, 2, 3, 4, 5)
 *       .limit(3)
 *       .forEach(System.out::println); // 输出：1 2 3
 * }</pre>
 * <p>限制返回的元素数量或跳过指定数量的元素。</p>
 *<p>limit(n) 用于返回前n个元素，skip(n) 用于跳过前n个元素。</p>
 * <h2>常见终端操作：</h2>
 *
 * <h3>1. forEach()</h3>
 * <pre>{@code
 * Stream.of("A", "B", "C").forEach(System.out::println); // 输出：A B C
 * }</pre>
 * <p>遍历 Stream 中的每个元素。</p>
 * <p><b>注意：forEach() 是一个终结方法，使用后会关闭 Stream。</b></p>
 *
 * <h3>2. collect()</h3>
 * <pre>{@code
 * List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
 * System.out.println(list); // 输出：[a, b, c]
 * }</pre>
 * <p>将 Stream 的结果收集为集合。</p>
 *
 * <h3>3. count()</h3>
 * <pre>{@code
 * long count = Stream.of(1, 2, 3).count();
 * System.out.println("Count: " + count); // 输出：Count: 3
 * }</pre>
 * <p>统计元素数量。</p>
 *
 * <h3>4. reduce()</h3>
 * <pre>{@code
 * Optional<Integer> sum = Stream.of(1, 2, 3).reduce(Integer::sum);
 * sum.ifPresent(System.out::println); // 输出：6
 * }</pre>
 * <p>将元素合并为一个结果。</p>
 *
 * <h3>5. anyMatch()、allMatch() 和 noneMatch()</h3>
 * <pre>{@code
 * boolean anyMatch = Stream.of(1, 2, 3).anyMatch(x -> x > 2);
 * System.out.println("Any match: " + anyMatch); // 输出：true
 * }</pre>
 * <p>匹配操作：检查是否有元素符合条件。</p>
 *
 * <h3>6. concat()</h3>
 *<pre>{@code
 * Stream<String> stream1 = Stream.of("a", "b", "c");
 * Stream<String> stream2 = Stream.of("d", "e", "f");
 * Stream<String> concatenated = Stream.concat(stream1, stream2);
 * concatenated.forEach(System.out::println); // 输出：a b c d e f
 * }</pre>
 * <p>连接两个 Stream。</p>
 *
 * <h2>并行流：</h2>
 * <pre>{@code
 * List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 * list.parallelStream().forEach(System.out::println);
 * }</pre>
 * <p>并行流支持并行处理，提升处理速度。</p>
 *
 * <h2>完整示例：</h2>
 * <pre>{@code
 * import java.util.*;
 * import java.util.stream.*;
 
 * public class StreamDemo {
 *     public static void main(String[] args) {
 *         List<String> words = Arrays.asList("hello", "world", "hello", "java");
 
 *         // 使用 Stream API 对集合进行操作
 *         List<Integer> lengths = words.stream()
 *                                      .distinct()
 *                                      .map(String::length)
 *                                      .collect(Collectors.toList());
 
 *         System.out.println(lengths); // 输出：[5, 4]
 *     }
 * }
 * }</pre>
 * <p>示例中，Stream API 用于去重、映射长度并收集为列表。</p>
 *
 * <h2>总结：</h2>
 * <ul>
 *   <li>Stream API 提供了一种声明式的数据处理方式。</li>
 *   <li>支持链式调用、并行处理和惰性求值。</li>
 *   <li>常见操作包括过滤、映射、排序、去重、统计和收集。</li>
 * </ul>
 */
class stream_example{
    public static void main(String[] args) {
        ArrayList<String> name_list = new ArrayList<>();
        name_list.add("张无忌");
        name_list.add("赵敏");
        name_list.add("周芷若");
        name_list.add("张三丰");
        name_list.add("张飞");
        name_list.add("赵敏");
        name_list.add("张军");
        name_list.add("张无语");
        
        Stream<String> name_list_stream = name_list.stream();
        
        name_list_stream.filter(name->name.startsWith("张"))
                .filter(name-> name.length()==3)
                .forEach(name-> System.out.println(name));
        
        // name_list_stream.forEach(name-> System.out.println(name));
        // 流已被链接或使用
        
        System.out.println(name_list.stream().count());
    }
}

