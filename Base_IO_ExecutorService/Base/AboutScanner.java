package Base;

import java.util.Scanner;

public class AboutScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 使用 nextInt() 读取整数
        System.out.print("Enter your age: ");
        int age=scanner.nextInt();
        System.out.println("Your age is: "+age);
        
        scanner.nextLine(); //忽略回车，读取的时候注意这个缓存
        
        // 使用 nextLine() 读取整行字符串，直到遇到换行符
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();
        System.out.println("You entered: " + line);
        
        // 使用 next() 读取单个单词，直到遇到空格或者换行符
        System.out.print("Enter a single word: ");
        String word = scanner.next();
        System.out.println("You entered: " + word);
        
        // 使用nextFloat()
        System.out.print("Enter a float number: ");
        float f = scanner.nextFloat();
        System.out.println("You entered a float number: " + f);
        
        // 使用nextDouble()
        System.out.print("Enter a double number: ");
        double d = scanner.nextDouble();
        System.out.println("You entered a double number: " + d);
        
        // 使用nextBoolean()
        System.out.print("Enter a boolean value: ");
        boolean b = scanner.nextBoolean();
        System.out.println("You entered a boolean value: " + b);
        
        // 使用hasNextXXX() 可以是int、float、double、boolean、String and so on
        System.out.println("enter a integer: ");
        if(scanner.hasNextInt()){
            int i = scanner.nextInt();
            System.out.println("You entered: " + i);
        }
        else {
            System.out.println("You did not enter an integer.");
        }
        
        // 连续接受输入，比如数组的初始化
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            if(scanner.hasNextInt()){
                arr[i] = scanner.nextInt();
            }
            else {
                System.out.println("You did not enter an integer.");
            }
        }
        for(int i=0;i<10;i++){
            System.out.println("arr["+i+"] = " + arr[i]);
        }
    }
}
