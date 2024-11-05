public class lifeline {
    /**
     * 1. 新生状态 New
     *    创建了线程对象，但还没有调用start()方法
     * 2. 可运行状态 Runnable
     *    线程已经调用了start()方法，但是可能还没有获取cpu执行权
     * 3. 运行状态 Running
     *    线程获得cpu执行权，执行run()方法
     * 4. 死亡状态 Dead
     *    线程执行完毕，run()方法结束
     * 5. 阻塞状态 Blocked
     *    wait() sleep() IO阻塞等
     * 6. 等待状态 Waiting
     *    wait() join() lock.await()等
     */
    public static void main(String[] args){
        Thread t = new Thread(() -> {
            System.out.println("线程开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束");
        });
        System.out.println("线程状态 " + t.getState());
        t.start();
        System.out.println("线程状态 " + t.getState());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程状态 " + t.getState());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程状态 " + t.getState());
    }
}

