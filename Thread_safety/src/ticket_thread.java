public class ticket_thread implements Runnable {
    private int ticket=10;
    
    final Object obj=new Object();
    @Override
    public void run(){
        while(ticket>0){
            synchronized (obj){
                ticket--;
                System.out.println(Thread.currentThread().getName()+" get one ticket,remain:"+ticket);
            }
        }
    }
}
