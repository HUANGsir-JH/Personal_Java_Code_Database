
class Resource {
    public synchronized void methodA(Resource resource) {
        System.out.println(Thread.currentThread().getName() + " acquired lock on " + this);
        // 模拟线程处理
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resource.methodB(this); // 试图获取对方的锁
    }
    
    public synchronized void methodB(Resource resource) {
        System.out.println(Thread.currentThread().getName() + " acquired lock on " + this);
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();
        
        Thread thread1 = new Thread(() -> resource1.methodA(resource2), "Thread_1");
        Thread thread2 = new Thread(() -> resource2.methodA(resource1), "Thread_2");
        /*
            运行过程
                线程1获取resource1的锁，然后试图调用resource2的methodB，需要获取resource2的锁。
                线程2获取resource2的锁，然后试图调用resource1的methodB，需要获取resource1的锁。
                此时，线程1和线程2互相等待对方释放锁，导致死锁。
         */
        
        thread1.start();
        thread2.start();
    }
}
/*
  死锁的条件
  1. 死锁通常需要满足以下四个条件：
  2. 互斥条件：至少有一个资源是以非共享的方式占用的，即至少有一个线程持有某个资源，其他线程不能同时访问。
  3. 持有并等待条件：一个线程持有至少一个资源，并等待获取其他资源。
  4. 不剥夺条件：已经分配给线程的资源在未使用完之前，不能被强行剥夺，只能在线程自己释放之后才能被其他线程使用。
  5. 循环等待条件：存在一个线程等待链，线程 A 等待线程 B 持有的资源，线程 B 等待线程 C 持有的资源，
      直到线程 Z 等待线程 A 持有的资源，形成一个环。
 */

/*
    如何避免死锁
    1. 避免互斥：尽量使用可共享资源，避免资源的独占。
    2. 避免持有并等待：在请求资源之前释放当前持有的资源。
    3. 避免不剥夺：可以考虑设置资源的超时机制，强制释放资源。
    4. 避免循环等待：确保线程请求资源的顺序一致，或使用优先级策略。
 */

