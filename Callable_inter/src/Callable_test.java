import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * callable和runnable联系和区别：
 *      联系：
 *          1.都可以创建一个新的线程
 *      区别：
 *          1.callable中是<V> call()方法，runnable中是run()方法
 *          2.callable可以返回值或者抛出异常，runnable不行
 *          3.callable的run方法返回一个泛型对象，可以指定返回值类型,但必须是应用数据类型，比如Integer、Boolean等
 */


public class Callable_test {
    public static void main(String[] args) {
        counter c=new counter();
        FutureTask<Integer> call_task=new FutureTask<>(c);
        Thread t1=new Thread(call_task,"t1");// 用一个FutureTask来创建线程。
        t1.start();
        try {
            System.out.println(call_task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

