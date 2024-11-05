import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Char_Out_In_Stream {
    public static void main(String[] args) {
    
    }
}


/**
 *
 * 注意：字符流专门用于文档操作，如果要复制文件，应该用字节流
 * 、
 * 1.字符输入流：
 *      -> Reader:抽象类 -> 子类：FileReader
 *      -> 构造：FileReader(String path) path:文件路径
 *      -> 构造：FileReader(File file)
 *      -> 方法：
 *          int read() -> 一次读取一个字符，返回的是读取的字符对应的int值
 *          int read(char[] cbuf) -> 一次读取一个数组，返回的是读取的字符个数
 *          int read(char[] cbuf,int off,int len) -> 一次读取一个数组的部分，返回的是读取的字符个数
 *          void close() -> 关闭流，需要手动关闭
 *\
 * 2.字符输出流：
 *      -> Writer:抽象类 -> 子类：FileWriter
 *      -> 构造：FileWriter(String path) path:文件路径
 *      -> 构造：FileWriter(File file)
 *                指定的文件如果不存在，程序会自动创建，每次执行程序，文件内容会被覆盖
 *                append:追加内容到文件末尾，FileWriter方法中添加true表示追加，不会覆盖原有内容
 *      -> 方法：
 *          void write(int c) -> 一次写一个字符
 *          void write(char[] cbuf) -> 一次写一个数组
 *          void write(char[] cbuf,int off,int len) -> 一次写一个数组的部分
 *          void write(String str) -> 一次写一个字符串
 *          void flush() -> 刷新缓冲区，将缓冲区中的数据刷新到文件中
 *               FileWrite底层自带一个缓冲区，一次写入不会立即写入到文件中，而是先写入缓冲区，缓冲区满了之后才会写入到文件中
 *          void close() -> 关闭流，需要手动关闭
 */

class char_input{
    File input_file=new File("D:\\IDEA_Java\\Java_Learning\\IO\\TestExample\\Chinese_text.txt");
    
    public void read_one_char() throws IOException {
        FileReader fr=new FileReader(input_file);
        int data;
        while ((data=fr.read())!=-1){
            System.out.print((char) data); //记得进行强制转换，返回值其实是字符对应的整数
        }
        fr.close();
    }
    
    public void read_one_array() throws IOException {
        FileReader fr=new FileReader(input_file);
        char[] cbuf =new char[10];
        int len;
        while ((len=fr.read(cbuf))!=-1){
            System.out.print(new String(cbuf,0,len));
        }
        fr.close();
    }
    
    public static void main(String[] args) throws IOException {
        char_input ci=new char_input();
//        ci.read_one_char();
        ci.read_one_array();
    }
}

class char_output{
    File output_file=new File("D:\\IDEA_Java\\Java_Learning\\IO\\TestExample\\Char_text.txt");
    
    public void write_string() throws IOException {
        FileWriter fw=new FileWriter(output_file);// 追加一个true参数表示在文件原有内容追加新内容，没有就是覆写
        fw.write("千山鸟飞绝\r\n");
        fw.write("万径人踪灭\r\n");
        fw.write("孤舟蓑笠翁\r\n");
        fw.write("独钓寒江雪\r\n");
        fw.write("姑苏城外寒江雪\r\n");
        fw.write("知否知否，应是绿肥红瘦\r\n");
        fw.flush();// flush只会刷新缓冲区，不会关闭输出流
        // 但关闭输出流就会刷新缓冲区。
    }
    
    public void write_one_array(char[] chars) {
        // JDK7之后的写法，把io对象放到try括号中
        // 无需手动关闭io流
        // 分号可带可不带，最好带，有时需要同时传入两个io对象，用分号隔开
        try(FileWriter fw=new FileWriter(output_file);){
            fw.write(chars);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {
        char_output co=new char_output();
//        co.write_string();
        co.write_one_array(new char[] {'学','J','a','v','a','真','的','烦'});
    }
}