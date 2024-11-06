import java.io.*;

public class transform {
    public static void main(String[] args) {
    
    }
}

/**
 *
 * 1. 读取转换流
 *          InputStreamReader
 *              -> 构造：InputStreamReader(FileInputStream in, String charsetName) ：charsetName:编码格式，不区分大小写
 *                      按照指定的编码去读取文件，若不指定，默认是utf-8，utf-8一个汉字占用3个字节，gbk是两个字节
 *                      可以根据文件的大小来判断是什么编码格式
 *                      或者打开记事本查看右下角 UTF-8 ->UTF8 ; GBK ->ANSI
 *              -> 方法： 和 FileReader 一致
 * 2. 输出转换流
 *          OutputStreamWriter
 *              -> 构造：OutputStreamWriter(FileOutputStream out, String charsetName) ：charsetName:编码格式，不区分大小写
 *                      按照指定的编码写入文件，若不指定，则默认是utf-8
 *              -> 方法： 和 FileWriter 一致
 */

class utf8_to_gbk{
    static File utf8_file=new File("D:\\IDEA_Java\\Java_Learning\\Transform_Stream\\utf_8_text.txt");
    static File gbk_file=new File("D:\\IDEA_Java\\Java_Learning\\Transform_Stream\\copied_gbk_text_from_utf8.txt");
    
    public static void main(String[] args) {
        try (InputStreamReader isr=new InputStreamReader(new FileInputStream(utf8_file),"UTF-8");
             OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(gbk_file),"gbk"))
        {
            int len;
            while ((len= isr.read())!=-1){
                osw.write(len);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class gbk_to_utf8{
    static File utf8_file=new File("D:\\IDEA_Java\\Java_Learning\\Transform_Stream\\copied_utf8_text_from_gbk.txt");
    static File gbk_file=new File("D:\\IDEA_Java\\Java_Learning\\Transform_Stream\\gbk_text.txt");
    
    public static void main(String[] args) {
        try (InputStreamReader isr=new InputStreamReader(new FileInputStream(gbk_file),"gbk");
             OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(utf8_file),"UTF-8"))
        {
            int len;
            while ((len= isr.read())!=-1){
                osw.write(len);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}