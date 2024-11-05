public class counter extends Thread{
    private static int count=0;
    // 设置为静态的属性，让全局变量在整个类内共享
    private static final Object lock=new Object();
    // 创建一个对象用来保证线程安全
    public counter(String name){
        super(name);
    }
    public void run(){
        while (count<9){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock){
                count++;
                System.out.println(Thread.currentThread().getName()+" increment:"+count);
            }
        }
    }
}
