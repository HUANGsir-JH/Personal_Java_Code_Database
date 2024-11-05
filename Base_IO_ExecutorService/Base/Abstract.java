package Base;

public class Abstract {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello World");

        Animal cat = new Cat();
        cat.eat();
        cat.sleep();
        cat.breath();
    }
}

abstract class Animal{
    abstract void eat();
    abstract void sleep();
    public void breath() {
        System.out.println("I can breath");
    }
}

class Cat extends Animal{
    public void eat() {
        System.out.println("Cat can eat.");
    }
    public void sleep() {
        System.out.println("Cat can sleep.");
    }

    public void breath() {
        System.out.println("Cat can breath.");
    }
}
