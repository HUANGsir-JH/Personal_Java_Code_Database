import java.io.*;

public class Char_Buffer_Stream {
    public static void main(String[] args) {
    
    }
}

/**
 *使用缓冲流，这些读写操作会在内存中缓存一部分数据，减少与底层设备的交互次数，提升性能
 * 、
 * 1.字节缓冲输出流：
 *        java.io.BufferedOutputStream
 *              -> 构造：BufferedOutputStream(OutputStream out)
 *              -> 构造：BufferedOutputStream(OutputStream out,int size) ：size:缓冲区的大小
 *              -> 方法：和FileOutputStream相同
 *        java.io.BufferedInputStream
 *              -> 构造：BufferedInputStream(InputStream in)
 *              -> 构造：BufferedInputStream(InputStream in,int size):int size
 *              -> 方法：和FileInputStream相同
 * 2.字符缓冲输出流：
 *        java.io.BufferedWriter
 *              -> 构造：BufferedWriter(Writer out)
 *              -> 构造：BufferedWriter(Writer out,int size) ：size:缓冲区的大小
 *              -> 方法：和FileWriter相同
 *              -> 特有方法：newLine() :换行
 *        java.io.BufferedReader
 *              -> 构缓：BufferedReader(Reader in)
 *              -> 构造：BufferedReader(Reader in,int size):int size
 *              -> 方法：和FileReader相同
 *              -> 特有方法：String readLine() :一次读一行，如果读到结束标识，返回null
 */

class normal_file_copy{
    static File file=new File("D:\\IDEA_Java\\Java_Learning\\IO_Buffer\\OIP.jpg");
    static File copy_file=new File("D:\\IDEA_Java\\Java_Learning\\IO_Buffer\\Copied_OIP.jpg");
    public static void main(String[] args){
        long start=System.currentTimeMillis();
        try(FileInputStream fis=new FileInputStream(file);
            FileOutputStream fos=new FileOutputStream(copy_file);){
            int len;
            while ((len=fis.read())!=-1){
                fos.write(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println("用时："+(end-start)+"ms");
        
        // 耗时70ms
    }
}

// 字节缓冲流
class buffered_file_copy{
    static File file=new File("D:\\IDEA_Java\\Java_Learning\\IO_Buffer\\OIP.jpg");
    static File copy_file=new File("D:\\IDEA_Java\\Java_Learning\\IO_Buffer\\Copied_OIP_1.jpg");
    
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        try (BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(copy_file));
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file))){
            int len;
            while ((len=bis.read())!=-1){
                bos.write(len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        
        System.out.println("用时："+(end-start)+"ms");
        
        // 耗时8ms
    }
}

// 字符缓冲流
class buffered_char_file_copy{
    static File original_file=new File("D:\\IDEA_Java\\Java_Learning\\IO_Buffer\\chinese_text_buffer.txt");
    static File copy_file=new File("D:\\IDEA_Java\\Java_Learning\\IO_Buffer\\chinese_text_buffer_copy.txt");
    
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        try (BufferedReader br=new BufferedReader(new FileReader(original_file));
        BufferedWriter bw=new BufferedWriter(new FileWriter(copy_file,true));){
            String line;
            while ((line= br.readLine())!=null){
                bw.newLine();
                bw.write(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long end=System.currentTimeMillis();
        
        System.out.println("用时："+(end-start)+"ms");
        
        // 2ms
    }
}

/*
  try (BufferedReader br=new BufferedReader(new FileReader(original_file));
          BufferedWriter bw=new BufferedWriter(new FileWriter(copy_file,true));){
              int len;
              char[] chars=new char[10];
              while ((len= br.read(chars))!=-1){
                  bw.newLine();
                  bw.write(chars,0,len);
              }
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
 */