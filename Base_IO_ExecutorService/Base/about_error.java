package Base;

import org.junit.jupiter.api.Test;

public class about_error {
    public static void main(String[] args) {
    
    }
    @Test
    public void test() {
        int i = 0;
        int j = 0;
        try {
            i = 10;
            j = 0;
            int k = i / j;
            System.out.println(k);
        } catch (Exception e) {
            System.out.println(e);
            j = 1;
            int k = i / j;
            System.out.println(k);
        } finally {
            System.out.println("finally");
        }
    }
}

class set_error{
    public static void main(String[] args) {
//        try{
//
//        }catch (){
//
//        }
//        catch (){
//
//        }finally {
//
//        }
        // 异常：try-catch-finally
        // 语法：try{...}catch(Exception e){...}finally{...}
        
        int i=0;
        int j=0;
        try{
            i=10;
            j=0;
            int k = i/j;
            System.out.println(k);
        }catch (Exception e){
            System.out.println(e);
            j=1;
            int k = i/j;
            System.out.println(k);
        }finally {
            System.out.println("finally");
        }
        //todo 常见异常：
        // NullPointerException->指向null的引用,空指针异常,调用了一个为空对象的成员属性或者成员方法
        // ArithmeticException->算术异常
        // NumberFormatException->数字格式异常
        // ArrayIndexOutOfBoundsException->数组越界异常
        // IOException->输入输出异常
    }
}

class throw_error{
    public static void main(String[] args) {
//        int age;
//        int age1;
//        age=-1;
//        age1=18;
//        try{
//            checkAge(age);
//            checkAge(age1);
//        }catch (Exception e){
//            System.out.println(e);
//        }
        
        int i,j;
        i=10;
        j=0;
        try{
            test(i,j);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void checkAge(int age) throws Exception{
        try {
            if (age < 0) {
                throw new Exception("Age cannot be negative");
            }
            System.out.println("Valid age: " + age);
        }
        catch (Exception e) {
            throw new Exception("Age cannot be negative");
        }
    }
    
    public static void test(int i,int j) throws Exception{
        try{
            System.out.println(i/j);
        }
        catch (ArithmeticException e){
            throw new Exception("除数不能为0");
        }
    }
}


// 自定义异常类
class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}

// 登录处理类
class LoginSystem {
    public static void main(String[] args) {
        try {
            login("user", "wrongPassword"); // 测试登录失败情况
        } catch (InvalidLoginException e) {
            System.out.println("捕获到异常: " + e.getMessage());
        }
    }
    
    public static void login(@org.jetbrains.annotations.NotNull String username, String password) throws InvalidLoginException {
        String correctUsername = "user";
        String correctPassword = "password123";
        
        if (!username.equals(correctUsername) || !password.equals(correctPassword)) {
            throw new InvalidLoginException("用户名或密码错误");
        }
        
        System.out.println("登录成功");
    }
}

