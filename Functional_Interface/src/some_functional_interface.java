import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class some_functional_interface {
    public static void main(String[] args) {
    
    }
}

class about_supplier {
    public static void main(String[] args) {
        method(() -> {
            int[] arr={1,2,3,4,5,6,7,8,9,10};
            Arrays.sort(arr);
            return arr[arr.length-1];
        });
    }
    
    /**
     * 供给型接口supplier
     *      是一个不接受参数但返回一个值的接口
     *      Supplier<T>接受Supplier<T>类型的参数，返回T类型的值
     *      内部抽象方法get()，是一个函数式接口
     */
    public static void method(Supplier<Integer> supplier) {
        Integer max=supplier.get();
        System.out.println("max="+max);
    }
}

class about_consumer {
    public static void main(String[] args) {
        method((String s)-> System.out.println(s.length()), "hello");
    }
    
    /**
     * 消费型接口consumer
     *      用于消费数据，即接收一个参数但不返回任何结果
     *      内部有抽象方法accept(),是一个函数式接口
     */
    public static void method(Consumer<String> consumer,String s){
        consumer.accept(s);
    }
}


class about_function{
    public static void main(String[] args) {
        method(s-> s.length(), "hello");
    }
    
    /**
     *
     * 函数型接口function
     *      用于接收一个参数，返回一个结果
     *      内部有抽象方法apply(),是一个函数式接口
     */
    public static void method(Function<String,Integer> function, String s){
        System.out.println(function.apply(s));
    }
}

class about_predicate{
    public static void main(String[] args) {
        method(s-> s.length()>=5, "hello");
        method(s-> s.length()>=5, "hello world");
    }
    
    public static void method(Predicate<String> predicate, String s) {
        boolean res=predicate.test(s);
        System.out.println(res);
    }
}






