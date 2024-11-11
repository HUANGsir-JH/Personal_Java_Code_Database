import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HexFormat;

public class file_upload {
    public static void main(String[] args) {
    
    }
}


class client{
    public static void main(String[] args) {
        try (Socket client_socket = new Socket("127.0.0.1",9090)) {
            File up_file=new File("D:\\IDEA_Java\\Java_Learning\\Network_Programming\\client_to_send\\OIP.jpg");
            BufferedInputStream bis=new BufferedInputStream(new FileInputStream(up_file));
            OutputStream client_socketOutputStream = client_socket.getOutputStream();
            // 边读边发送
            byte[] up_bytes=new byte[1024];
            int len;
            while ((len=bis.read(up_bytes))!=-1){
                client_socketOutputStream.write(up_bytes,0,len);
            }
            /**
             *             client_socket.shutdownOutput();
             * 文件在读取的过程中，读到返回值是-1，代表到达了文件末尾，就会跳出循环，但是这个结束标记
             * 并不会发送到服务端，会导致服务端以为还有数据而一直阻塞等待，所以要显式通知服务端发送结束
             */
            // 显式关闭输出流，通知服务器发送结束
            client_socket.shutdownOutput();
            System.out.println("文件发送成功");
            
            InputStream client_socketInputStream = client_socket.getInputStream();
            byte[] down_bytes=new byte[1024];
            int len1=client_socketInputStream.read(down_bytes);
            System.out.println(new String(down_bytes,0,len1));
            
            bis.close();
            client_socketOutputStream.close();
            client_socketInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class server{
    public static void main(String[] args) throws Exception {
        ServerSocket server_socket=new ServerSocket(9090);
        
        // 保证服务端一直处于连接状态
        while (true){
            // 等待客户端连接
            Socket client_socket=server_socket.accept();
            
            new Thread(() -> {
                
                InputStream client_socketInputStream=null;
                BufferedOutputStream bos=null;
                OutputStream client_socketOutputStream=null;
                
                try {
                    client_socketInputStream = client_socket.getInputStream();
                    
                    // 读取文件头部用于识别类型
                    byte[] header=new byte[8];
                    client_socketInputStream.read(header);
                    String fileType=getFileType(header);
                    
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HHmmss");
                    // 设置文件名,注意文件名中不可以有冒号！！！！！！
                    String path="up_load_"+sdf.format(new Date(System.currentTimeMillis()))+fileType;
                    File down_file_path=new File("D:\\IDEA_Java\\Java_Learning\\Network_Programming\\server_to_receive\\"+path);
                    /**
                     * 通过时间戳命名来防止由于文件名相同导致的覆盖
                     * 此外，还可以用UUID：
                     *       String path=UUID.randomUUID().toString();
                     *       File down_file_path=new File("D:\\IDEA_Java\\Java_Learning\\Network_Programming\\server_to_receive\\"+path);
                     */
                    bos=new BufferedOutputStream(new FileOutputStream(down_file_path));
                    
                    // 写入之前的八个字节
                    bos.write(header);
                    // 边接收边写
                    byte[] down_bytes=new byte[1024];
                    int len;
                    while ((len=client_socketInputStream.read(down_bytes))!=-1){
                        bos.write(down_bytes,0,len);
                    }
                    
                    System.out.println("文件接收成功");
                    
                    client_socketOutputStream = client_socket.getOutputStream();
                    client_socketOutputStream.write("文件接收成功".getBytes());
                    
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }finally {
                    CloseUtil.closeQuietly(client_socket,bos,
                            client_socketInputStream,client_socketOutputStream);
                }
            }).start();
        }
    }
    
    private static String getFileType(byte[] header) {
        // 利用magic number来判断文件类型
        
        // magic number,把字节转换为十六进制数
        String file_header= HexFormat.of().formatHex(header).toUpperCase();
        
        // 判断文件类型
        if(file_header.startsWith("FFD8FF")){
            return ".jpg";
        }else if (file_header.startsWith("89504E47")){
            return ".png";
        }else if (file_header.startsWith("47494638")){
            return ".gif";
        } else if (file_header.startsWith("504446")) {
            return ".pdf";
        } else if (file_header.startsWith("504B0304")) {
            return ".zip";
        } else if (file_header.startsWith("255044462D")) {
            return ".pdf";
        } else if (file_header.startsWith("D0CF11E0")) {
            // MS Office 文件
            return ".doc";
        } else if (file_header.startsWith("52494646")) {
            return ".wav";
        } else if (file_header.startsWith("4D546864")) {
            return ".midi";
        }
        
        return ".unknown";
    }
}

class CloseUtil{
    public static void closeQuietly(Closeable... closeable){
        for (Closeable close : closeable) {
            try {
                if (close!=null){
                    close.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}