package Base;

import java.util.Scanner;

public class ThrowError {
        public static void main(String[] args) {
            int age;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your age: ");
            age = sc.nextInt();
            checkAge(age);
        }
        
        public static void checkAge(int age) {
            if (age <= 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            System.out.println("Valid age: " + age);
        }
}
