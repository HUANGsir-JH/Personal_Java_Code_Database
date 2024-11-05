public class the_thread {
    public static void main(String[] args) {
        thread_1 t1=new thread_1();
        t1.start();
        t1.setName("t1");
        t1.setPriority(10);// 给线程设置优先级，最高优先级时10，最低优先级是1，默认优先级是5

        thread_1 t2=new thread_1();
        t2.start();
        t2.setName("t2");
        t2.setPriority(1);
        
        thread_2 t3=new thread_2();
        t3.setDaemon(true);// 设置守护线程，当其他的线程执行完毕后，该线程自动结束。
        // 但是其他线程结束时系统关闭该线程需要一定时间，因此会延迟一会后进行关闭
        // 守护线程需要在线程start前就进行声明，否则无效并且报错。
        t3.start();
        t3.setName("t3");
        

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
