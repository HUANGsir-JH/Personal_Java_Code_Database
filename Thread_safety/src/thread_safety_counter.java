public class thread_safety_counter {
    public static void main(String[] args) {
        counter c1=new counter("c1");
        counter c2=new counter("c2");
        c1.start();
        c2.start();
    }
}
