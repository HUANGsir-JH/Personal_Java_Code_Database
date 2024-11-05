public class thread_safety_ticket {
    public static void main(String[] args) {
        ticket_thread t=new ticket_thread();
        
        Thread thread1=new Thread(t,"t1");
        Thread thread2=new Thread(t,"t2");
        thread1.start();
        thread2.start();
    }
}
