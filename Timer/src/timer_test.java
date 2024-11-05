import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class timer_test {
    public static void main(String[] args) {
        Timer t=new Timer();
        t.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("hello,world");
            }
        },new Date(),1000);
        // Timer t=new Timer();  //Timer是一个工具类，Schedule一个任务
        // t.schedule(new TimerTask() {
        //     @Override
        //     public void run() {
        //         System.out.println("hello,world");
        //     }
        // },new Date(),2000);  //schedule方法，接受一个TimerTask对象，一个Date对象和一个long整数
        //                       TimerTask是一个实现了runnable接口的类，用来创建一个线程任务
        //                       Date对象表示执行的时间（new Date()就是当前实践），
        //                       long整数表示执行的间隔（毫秒）
        //
    }
}
