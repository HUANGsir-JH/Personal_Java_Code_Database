package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// callable 对比 runnable
// callable 可以返回值或者抛出异常，runnable 不行
// callable 的run方法返回一个泛型对象，可以指定返回值类型

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
            System.out.println("Callable Thread: Sum = " + sum);
            Thread.sleep(500);
        }
        return sum; // 返回计算结果
    }
}
// todo:Future：存储和管理任务结果
//Future 接口用于表示异步计算的结果。Future 是 Callable 的配套工具，
//它可以用于检查任务是否完成、等待任务的完成，并获取任务的执行结果。
// todo:Future 的常见方法：
// boolean isDone()：判断任务是否已经完成。
// V get()：获取任务执行的结果，若任务未完成，会一直阻塞等待。
// boolean cancel(boolean mayInterruptIfRunning)：尝试取消任务。
// boolean isCancelled()：判断任务是否被取消。
public class about_callable_future {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable(); // 创建callable对象
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable); // 包装成FutureTask
        Thread thread = new Thread(futureTask); // 用FutureTask创建一个线程用来启动
        // 和之前的thread、runnable等方法的线程创建都不同
        // 传入futuretask来创建线程，futuretask则是传入callable对象来创建
        thread.start();
        
        // 主线程继续执行
        try {
            System.out.println("主线程继续运行...");
            int result = futureTask.get(); // 获取Callable返回的结果
            // 任务未完成会一直阻塞等待
            System.out.println("Callable线程返回的结果: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
