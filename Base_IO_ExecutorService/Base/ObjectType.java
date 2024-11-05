package Base;

import java.util.Scanner;

public class ObjectType {
    public static void main(String[] args) {
    
    }
}

class integer{
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Integer i = console.nextInt();
        Integer j = console.nextInt();
        if(i.equals(j)){
            System.out.println("i = j");
        }
        else{
            System.out.println("i!=j");
        }
    }
    int x=10;
    //Integer y= Integer.valueOf(20);//将int转换为Integer
    //存在自动装箱
    Integer y=20;//自动装箱,不需要valueOf
    //int z=y.intValue();//自动拆箱
    //自动拆箱
    int z=y;//自动拆箱
}
