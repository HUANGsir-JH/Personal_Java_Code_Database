package thread;

public class about_Runnable {
    public static void main(String[] args) {
        thread2 t2=new thread2(); // 创建runnable对象
        Thread t=new Thread(t2); // 创建线程对象并且传入runnable对象
        //而在实现 Runnable 接口的方式中，你不是直接继承 Thread 类，
        // 而是将任务定义在一个实现了 Runnable 接口的类的 run() 方法中。
        // 然后，通过 Thread 类的构造器，
        // 将 Runnable 对象传递给一个 Thread 对象，这样就分离了任务的定义和线程的创建。
        
        t.start(); // 不要直接调用run方法，要调用start方法
        for (int i=0;i<4;i++){
            System.out.println("main:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class thread2 implements Runnable{ // 实现Runnable接口，之后重写run()方法来实现多个进程
    @Override
    public void run(){
        for (int i=0;i<4;i++){
            System.out.println("thread2:"+i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
