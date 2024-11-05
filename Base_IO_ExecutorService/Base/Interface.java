package Base;

public class Interface {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        System.out.println("Hello World!");

        car su7 = new xiaomiSu7();
        su7.run();
        su7.stop();
        su7.start();
        su7.drive();
        
    }
}

interface car{
    void run();
    void stop();
    void start();
    void drive();
}

class xiaomiSu7 implements car{
    int price=29;
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("run "+price);
    }

    public void stop() {
        // TODO Auto-generated method stub
        System.out.println("stop");
    }

    public void start() {
        // TODO Auto-generated method stub
        System.out.println("start");
    }

    public void drive() {
        // TODO Auto-generated method stub
        System.out.println("drive");
    }
}





