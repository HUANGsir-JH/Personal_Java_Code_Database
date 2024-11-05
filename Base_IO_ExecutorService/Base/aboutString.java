package Base;

public class aboutString {
    public static void main(String[] args) {
        String s1="hjh";
        String s2="hjh";
        if (s1.equals(s2)){
            System.out.println(true);
        }
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareToIgnoreCase(s2));
        
        String s3="Hello";
        System.out.println(s3.substring(0,3));
        
        String s4="hello world hjh";
        String[] s_divid = s4.split(" ");//用“regex”来对字符串进行分割，并且返回一个数组
        for (String i:s_divid){
            System.out.printf(i+" ");
        }
        System.out.println();
        
        String s5=" hello world ";
        System.out.print(s5.trim());
        
        String s6="hello world hjh";
        System.out.println(s6.replace("hjh","java"));//replace将字符串中的hjh替换为java
        System.out.println(s6.replaceAll("world|hjh", "java"));//replaceAll将字符串中的world|hjh替换为java
    }
}
