import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_1 {
    private final Lock lock = new ReentrantLock();// 使用ReentrantLock，默认是非公平锁，即抢占
    // Lock 是一个接口，里面有两个方法：lock() 和 unlock()
    // lock() 加锁，unlock() 解锁
    // ReentrantLock 默认是非公平锁，即抢占，传入true则是公平锁，ReentrantLock(true)
    private int counter = 0;
    
    public void increment() {
        while (counter<30){
            lock.lock(); // 显式加锁
            try {
                counter++;
                System.out.println("Counter = " + counter);
            } finally {
                lock.unlock(); // 显式解锁，确保即使出现异常也会释放锁
            }
        }
    }
    
    public static void main(String[] args) {
        Lock_1 example = new Lock_1();
        
        Runnable task = example::increment;
        // 相当于：
        // Runnable task = ()->{
        //     example.increment();
        //   };
        
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        
        t1.start();
        t2.start();
    }
}
