import java.io.*;

public class print {
    public static void main(String[] args) {
    
    }
}

/**
 * 字节打印流：
 *      1. 构造： PrintStream(String FileName) 构造一个打印流
 *                  一个字节打印流，通常用于输出字节数据，能够自动刷新缓冲区。
 *               PrintStream(OutputStream out) 构造一个打印流
 *                  可以利用OutputStream对象的{append：true}来实现内容追加的功能
 *      2. 方法： 1.println()
 *               2.print()
 *               3.printf()
 *
 * 改变流向：
 *      System.setOut(PrintStream) : 设置系统的输出流,输出到指定的文件当中
 *      -> 可以把输出的内容以及详细的信息放到日志文件当中进行保存
 *
 * 字符打印流：
 *      1. 构造： PrintWriter(FileWriter fw) 构造一个打印流
 */

class print_stream{
    static File out_file=new File("D:\\IDEA_Java\\Java_Learning\\Print_Stream\\out_file.txt");
    
    public static void main(String[] args) {
        try(PrintStream ps=new PrintStream(out_file)){
            ps.println("朱门酒肉臭");
            ps.println("路有冻死骨");
            ps.print("\n白日依山尽");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class  change_print_stream{
    static File console_log=new File("D:\\IDEA_Java\\Java_Learning\\Print_Stream\\console_log.txt");
    
    public static void main(String[] args) {
        try(PrintStream ps=new PrintStream(console_log)){
            System.setOut(ps); // 设置系统的输出流，输出到指定的文件当中
            System.out.println("想见你只想见你");
            System.out.println("鲜衣怒马少年时");
            System.out.print("\n无人问我心，只恨不相识\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class  change_print_stream_append{
    static File console_log=new File("D:\\IDEA_Java\\Java_Learning\\Print_Stream\\console_log.txt");
    
    public static void main(String[] args) {
        try(PrintStream ps=new PrintStream(new FileOutputStream(console_log,true))){
            // 设置为true，表示内容追加
            System.setOut(ps); // 设置系统的输出流，输出到指定的文件当中
            System.out.println("想见你只想见你");
            System.out.println("鲜衣怒马少年时");
            System.out.print("\n无人问我心，只恨不相识");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class PrintWriterExample {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("Print_Stream\\output.txt"),
                true)) {
            // 自动刷新设置为 true
            
            // 输出字符串
            pw.println("Hello, PrintWriter!");
            
            // 格式化输出
            pw.printf("Value of PI: %.3f%n", Math.PI);
            
            System.out.println("数据写入完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}