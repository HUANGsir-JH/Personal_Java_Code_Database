package Base;

public class iostream {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello,please input your name:");
        byte[] b = new byte[1024];
        int len = System.in.read(b);
        String name = new String(b,0,len);
        System.out.println("Hello,"+name);
    }
}
