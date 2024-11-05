import java.io.*;

public class OutPut_InPut_Stream {
    public static void main(String[] args) {
    
    }
}

/**
 *      输出流 -> 往硬盘写数据
 *      输入流 -> 从硬盘读数据
 * /n
 * 字节流（万能流）：
 *      1.字节输出流：抽象类 OutputStream ->子类 FileOutputStream
 *                  -> 构造：FileOutputStream(String name) name:文件路径
 *                  -> 构造：FileOutputStream(File file)
 *                  指定的文件如果不存在，程序会自动创建；每次执行程序，文件内容会被覆盖
 *                  -> 方法：
 *                      void write(byte[] b,int off,int len) b:写的数组；off:起始索引,len:长度
 *                      void write(int b) b:写的数，一次写一个字节
 *                      void write(byte[] b) b:写的数组，一次写一个数组
 *                      void close() 关闭流，需要手动关闭
 *                      void flush() 刷新缓冲区，将缓冲区中的数据刷新到文件中
 *、
 *        字节输入流：抽象类 InputStream ->子类 FileInputStream
 *                  -> 构造：FileInputStream(String path) path:文件路径
 *                  -> 构造：FileInputStream(File file)
 *                  没有自动创建文件的功能
 *                  -> 方法：
 *                      int read() 一次读一个字节，返回的是读取的字节
 *                                        如果已经到达文件末尾，返回-1
 *                      int read(byte[] b) 一次读一个数组，返回的是读取的字节个数
 *                      int read(byte[] b,int off,int len) 一次读一个数组的部分，返回的是读取的字节个数
 *                      void close() 关闭流，需要手动关闭
 *      2.字节缓冲流：BufferedInputStream，BufferedOutputStream
 * 字符流：
 *      1.字符输出流：Writer，字符输入流：Reader，都是抽象类
 *      2.字符缓冲流：BufferedReader，BufferedWriter
 */
class file_output{
    FileOutputStream fos;
    public file_output(String name){
        try {
            fos = new FileOutputStream(name);
            // fos = new FileOutputStream(new File(name),true); // 追加写入,不会覆盖原有内容
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void write_one_byte(int b) throws IOException {
        // 将整数b作为字节写入文件，而不是将整数本身写入文件。
        // 也就是说，b这个整数，对应的是ASCII码表中的一个字节
        fos.write(b);
        fos.close();
    }
    public void write_one_array(byte[] b) throws IOException {
        fos.write(b);
        fos.close();
    }
    public void write_one_array_sub(byte[] b,int off,int len) throws IOException {
        fos.write(b,off,len);
        fos.close();
    }
    
    public static void main(String[] args) throws IOException {
        file_output f = new file_output("D:\\IDEA_Java\\Java_Learning\\IO\\test.txt");
//        f.write_one_byte(98); // 文件：“b”
//        f.write_one_array(new byte[] {99,100,101,102,103,104}); // 文件：“cdefgh”
//        f.write_one_array("abc".getBytes()); // 文件：“abc”.把字符串转化为字节数组
//        f.write_one_array_sub(new byte[] {105,106,107,108,109,110},2,3); // 文件：“klm”,107->k
    }
}

class file_input{
    FileInputStream fis;
    public file_input(String name){
        try {
            fis = new FileInputStream(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void read_one_byte() throws IOException {
        int data;
        while ((data=fis.read()) != -1) {
            System.out.print((char) data); // 不强制转换的话输出的是字节码
        }
        // 如果写 int data = fis.read();
        //       while(data!=-1){}
        // 这样data是不会更新的，会死循环。
        fis.close();
    }
    public void read_one_array() throws IOException {
        byte[] bytes = new byte[10]; //一般设置为1024或者1024的倍数
        // 如果剩下的字节长度不足1024的话，read方法会返回实际读取的字节长度
        // 如果剩下的字节长度超过1024的话，read方法会返回1024
        int len;
        while ((len=fis.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len));
            // 把byte数组转化为字符串输出
        }
        fis.close();
    }
    
    
    public static void main(String[] args) throws IOException {
        file_input f = new file_input("D:\\IDEA_Java\\Java_Learning\\IO\\TestExample\\test_text.txt");
//        f.read_one_byte();
        f.read_one_array();
    }
}

class file_copy{
    public static void main(String[] args) throws Exception {
        File origin_image=new File("D:\\IDEA_Java\\Java_Learning\\IO\\TestExample\\OIP.jpg");
        FileOutputStream fos=new FileOutputStream("D:\\IDEA_Java\\Java_Learning\\IO\\TestExample\\Copied_OIP.jpg");
        FileInputStream fis=new FileInputStream(origin_image);
        byte[] bytes=new byte[1024];
        int len;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
    }
}
