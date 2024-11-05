package thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
// todo:   ExecutorService(线程池)的常见类型：
//      1.ExecutorService executor = Executors.newFixedThreadPool(5);
//              ->固定大小的线程池。线程池中的线程数量是固定的，不会随着任务数量的增加或减少而改变。
//              ->适用于任务量较为固定的情况。
//      2.ExecutorService executor = Executors.newSingleThreadExecutor();
//              ->单线程的线程池。保证所有任务在同一个线程中按顺序执行，适用于顺序执行任务的场景。
//      3.ExecutorService executor = Executors.newCachedThreadPool();
//              ->一个根据需要创建新线程的线程池。如果有空闲的线程可以复用，就复用它，
//                  否则就创建新的线程。如果线程空闲时间超过 60 秒，则会被销毁。
//              ->适用于任务量波动较大的情况
//      4.ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
//              ->支持定时和周期性执行任务的线程池。可以用来调度任务在固定延时后执行或者以固定周期重复执行。

// todo:   ExecutorService(线程池)的常见方法
//        1.Future<?> future = executorService.submit(() -> {});
//              -> submit(Runnable task)：提交一个 Runnable 任务给线程池执行，返回一个 Future 对象。
//        2.Future<Integer> result = executorService.submit(() -> { return ;})
//              -> submit(Callable<V> task)：提交一个 Callable 任务，返回 Future<V>，用于获取异步结果。
//        3.List<Future<Integer>> futures = executorService.invokeAll(tasks);
//              -> invokeAll(Collection<? extends Callable<T>> tasks)：批量提交 Callable 任务，返回一组 Future 对象。
//        4.Integer result = executorService.invokeAny(tasks);
//              -> invokeAny(Collection<? extends Callable<T>> tasks)：执行任务列表中的任意一个任务，并返回第一个完成的任务结果。
//        5.executorService.shutdown();
//              -> shutdown()：关闭线程池。
//        6.executorService.shutdownNow();
//              -> shutdownNow()：不管任务是否完成，直接关闭线程池。
//        7.executorService.awaitTermination(long timeout, TimeUnit unit);
//              -> awaitTermination(long timeout, TimeUnit unit)：等待线程池关闭，可以指定超时时间。
//              -> 阻塞当前线程，直到线程池关闭或超时。
//        8.executorService.isTerminated();
//              -> isTerminated()：判断线程池是否已经关闭。
//        9.executorService.isShutdown();
//              -> isShutdown()：判断线程池是否已经关闭。
public class about_ExecutorService {
    public static void main(String[] args) {
    
    }
}



// 主类，展示 ExecutorService、Callable、Future 及其组合使用
class ExecutorServiceExample {
    
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        // 创建一个存储 Callable 任务的列表
        List<Callable<Integer>> taskList = new ArrayList<>();
        
        // 添加几个简单的 Callable 任务，这些任务将返回一个整数结果
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            taskList.add(() -> {
                System.out.println("任务 " + taskId + " 开始执行...");
                Thread.sleep(1000);  // 模拟任务执行时间
                return taskId * 10;  // 返回任务的结果
            });
        }
        
        try {
            // invokeAll 方法批量执行 Callable 任务，并返回 Future 对象的列表
            List<Future<Integer>> futures = executorService.invokeAll(taskList);
            
            // 获取每个任务的结果
            for (Future<Integer> future : futures) {
                System.out.println("任务结果: " + future.get());  // Future.get() 将阻塞直到结果返回
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        // 提交单个 Callable 任务并使用 Future 获取其返回值
        Callable<String> callableTask = () -> {
            System.out.println("开始执行单个任务...");
            Thread.sleep(2000);
            return "单个任务完成!";
        };
        
        Future<String> future = executorService.submit(callableTask);
        
        try {
            // 使用 get 方法获取任务的结果
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        // 使用 ScheduledExecutorService 来调度任务
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        
        // 创建并调度一个任务，在延迟 3 秒后执行
        scheduledExecutorService.schedule(() -> {
            System.out.println("定时任务 1：延时 3 秒后执行");
        }, 3, TimeUnit.SECONDS);
        
        // 创建一个任务，每隔 2 秒固定执行一次
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("定时任务 2：每 2 秒执行一次");
        }, 1, 2, TimeUnit.SECONDS);
        
        // 创建一个任务，在上一个任务完成后延迟 2 秒再执行
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("定时任务 3：任务完成后延迟 2 秒再次执行");
        }, 1, 2, TimeUnit.SECONDS);
        
        // 主线程等待 10 秒，以便观察定时任务的执行
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // 关闭线程池
        executorService.shutdown();
        scheduledExecutorService.shutdown();
        
        try {
            // 等待所有任务执行完毕
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
            if (!scheduledExecutorService.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    
}


