public class bank {
    public static void main(String[] args) {
        account a=new account(); // 创建各线程操作的同一账户
        Thread t1=new Thread(a,"线程一");
        Thread t2=new Thread(a,"线程二");
        Thread t3=new Thread(a,"线程三");
        Thread t4=new Thread(a,"线程四");
        Thread t5=new Thread(a,"线程五");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class account implements Runnable{
    private int balance = 100;
    // 初始设定账户有100元
    @Override
    public void run(){
        withdraw(30);
        // 每次取出30元
    }
    
    public synchronized void withdraw(int amount){
        int newbalance = balance-amount;
        if (newbalance<0){
            System.out.println(Thread.currentThread().getName()+
                    "取钱失败"+ "，余额不足");
        } else {
            balance = newbalance;
            System.out.println(Thread.currentThread().getName()+
                    "取出"+amount+"，当前余额"+balance);
        }
    }
}