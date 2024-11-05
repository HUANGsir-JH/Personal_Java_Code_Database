public class counter_test {
    public static void main(String[] args) {
        counter c=new counter();
        Thread t1=new Thread(c,"t1");
        Thread t2=new Thread(c,"t2");
        t1.start();
        t2.start();
    }
}
