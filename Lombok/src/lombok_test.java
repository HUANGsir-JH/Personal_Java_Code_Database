import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class lombok_test {
    public static void main(String[] args) {
        lombok_example example = new lombok_example("jack",18);
        System.out.println(example);
        System.out.println(example.getName()+"..."+example.getAge());
        lombok_example example1 = new lombok_example();
        System.out.println(example1);
    }
}

// Lombok注解只能写在类上,位置有要求
@Data
@AllArgsConstructor
@NoArgsConstructor
class lombok_example {
    private String name;
    private int age;
}

/**
 * 1. @Data注解
 *      自动生成所有字段的getter/setter
 *      自动生成toString()、equals()、hashCode()
 * 2. @NoArgsConstructor/@AllArgsConstructor
 *      生成无参构造器
 *      生成包含所有字段的构造器
 * 3. @Getter/@Setter
 *      生成getter/setter
 * 4. @Builder
 *      生成建造者模式的代码
 *      支持链式调用来设置对象属性
 */