package thread;

public class about_thread {
    public static void main(String[] args) {
        thread1 t1 = new thread1(); // 创建线程
        //当你继承 Thread 类时，你可以直接重写 Thread 类的 run() 方法，
        // 将线程的任务逻辑写在里面，并通过调用 start() 方法启动线程。
        // 这种方式是让线程对象和执行任务直接绑定在一起。
        // 相较于实现runnable接口，继承thread类比较缺乏灵活性
        // 因为Java只能单继承
        
        t1.start();// 启动线程，不要直接调用run方法，要调用start方法
        for (int i=0;i<4;i++){
            System.out.println("main:"+i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


// todo: 线程的常见方法：
//start()：启动线程，调用该方法后线程进入可运行状态，JVM 会调用线程的 run() 方法。
//run()：线程的主要逻辑写在此方法中，但不要直接调用 run() 方法，而应使用 start()。
//sleep(long millis)：使当前线程暂停指定时间（毫秒）。
//join()：等待线程执行完毕再继续执行当前线程。
//yield()：让出当前线程的执行权限，但不一定会暂停。
//interrupt()：中断线程，设置线程的中断状态，线程需定期检查中断状态。


class thread1 extends Thread{ // 继承Thread，之后重写run()方法来实现多个进程，run方法内
    // 进行声明变量等基本操作，相当于多了一个public类。并且可以同时执行。
    @Override
    public void run() {
        for (int i=0;i<4;i++){
            System.out.println("thread1:"+i);
            try {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


