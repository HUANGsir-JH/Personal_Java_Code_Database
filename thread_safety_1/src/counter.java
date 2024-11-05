public class counter implements Runnable{
    private static int count=0;
    
    public synchronized void increment() { // 同步方法，添加synchronized关键字，
        // 默认的锁是对象this
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" increment:"+count++);
    }
    
    @Override
    public void run() {
        while (count < 9) {
            increment();
        }
    }
}
