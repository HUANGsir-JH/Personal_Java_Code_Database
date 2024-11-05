import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 关于lock：
 *       1. lock.tryLock() 尝试获取锁，获取成功返回true，否则返回false
 *       2. tryLock(long timeout, TimeUnit unit)：在指定的时间内尝试获取锁，若成功获取返回 true，否则返回 false。
 *       3. lockInterruptibly()：允许等待时被中断，适合在等待时间可能较长的场景下使用。
 *       4. lock.unlock():释放锁
 *       5. lock() 获取锁
 
 *       ReentrantLock 是一个可重入锁，即允许多个线程同时获取同一个锁。
 */
public class AdvancedLock {
    private final Lock lock = new ReentrantLock();
    
    public void doWork() {
        if (lock.tryLock()) { // 尝试获取锁
            try {
                System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                // 执行需要同步的代码
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " released the lock.");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " could not acquire the lock.");
        }
    }
    
    public void doWorkInterruptibly() {
        try {
            lock.lockInterruptibly(); // 等待获取锁的过程中可以被中断
            // lockInterruptibly() 是一个方法，它允许等待获取锁的过程中被中断。
            // 也就是说，如果线程在等待获取锁的过程中被其他线程中断，它会抛出 InterruptedException 异常，
            // 而不是继续等待。这种机制可以避免线程长时间等待锁而无法被中断
            // lock.lockInterruptibly() 并不是循环地“不断尝试”获取锁。
            // 它实际上进入了阻塞状态，等待锁的释放，只是在阻塞期间会对中断信号做出反应。
            // 这与 tryLock() 不同，tryLock() 在获取不到锁时会立即返回 false，不会进入等待。
            
            // 使用 lock.lockInterruptibly() 表明线程在等待锁的过程中可以响应中断。
            // 一旦调用线程的 interrupt()，该线程在被中断时会抛出 InterruptedException，从而停止等待锁。
            
            //如果使用的是 lock.lock() 而不是 lock.lockInterruptibly()，
            // 调用 interrupt() 不会中断锁的等待，线程会一直阻塞在获取锁的过程中，直到锁可用。
            try {
                System.out.println(Thread.currentThread().getName() + " acquired the lock with interruptible lock.");
                // 执行需要同步的代码
                Thread.sleep(200);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " released the interruptible lock.");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for the lock.");
        }
    }
    
    public static void main(String[] args) {
        AdvancedLock example = new AdvancedLock();
        
        Thread t1 = new Thread(example::doWork);
        Thread t2 = new Thread(example::doWork);
        Thread t3 = new Thread(example::doWorkInterruptibly);
        
        t1.start();
        t2.start();
        t3.start();
//        t3.interrupt(); 中断线程
    }
}
