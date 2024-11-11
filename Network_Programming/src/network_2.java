import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class network_2 {
    public static void main(String[] args) {
    
    }
}


/**
 * 1.   ServerSocket：用于创建服务器端的监听 socket。-> 服务端
 *          构建：ServerSocket socket = new ServerSocket(int port);-> 指定端口
 *          方法：void accept() -> 等待客户端连接,返回客户端的 socket对象
 *               void close() -> 关闭
 *               getLocalPort() -> 获取端口
 *               getLocalSocketAddress() -> 获取 socket 地址
 *               getInputStream() -> 获取输入流,用于接收数据
 *               getOutputStream() -> 获取输出流,用于发送数据
 *、
 *      Socket：用于创建客户端和服务器端通信的 socket。 -> 客户端
 *          构建：Socket socket = new Socket(String host, int port);-> 指定主机和端口
 *               Socket socket = new Socket(InetAddress address, int port);-> 指定地址和端口
 *          方法：getInputStream() -> 获取输入流,用于接收数据
 *               getOutputStream() -> 获取输出流,用于发送数据
 *               void close() -> 关闭
 * 2.
 */

class tcp_client{
    public static void main(String[] args) {
        try (Socket client_socket = new Socket("127.0.0.1",6060)) {// 客户端指定服务端的端口才可以进行连接
            OutputStream client_socketOutputStream = client_socket.getOutputStream();
            // 发送数据
            byte[] send_message = "aks for file".getBytes();
            client_socketOutputStream.write(send_message);
            System.out.println("send the message: "+new String(send_message));
            System.out.println(client_socket.getLocalPort());
            //getLocalPort() -> 获取本地端口 上面的6060时服务端固定端口，而不是指定本地端口为6060
            //也就是说，socket创建时指定的端口看得时服务端。本地端口由系统动态分布
            
            // 接收数据
            byte[] receive_message = new byte[1024];
            InputStream client_socketInputStream = client_socket.getInputStream();
            int len=client_socketInputStream.read(receive_message);
            System.out.println("get the message: "+new String(receive_message,0,len));
            System.out.println("client close");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

// 先启动服务端，再启动客户端
class tcp_server{
    public static void main(String[] args) {
        try (ServerSocket server_socket = new ServerSocket(6060)) {// 服务端指定端口
            // 等待客户端连接
            Socket client_socket = server_socket.accept();
            
            // 接收数据
            InputStream client_socketInputStream = client_socket.getInputStream();
            byte[] receive_message=new byte[1024];
            int len =client_socketInputStream.read(receive_message);
            System.out.println("get the message: "+new String(receive_message,0,len));
            
            // 发送数据
            OutputStream client_socketOutputStream = client_socket.getOutputStream();
            byte[] send_message;
            File file=new File("D:\\IDEA_Java\\Java_Learning\\Network_Programming\\FileToSend.txt");
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String fileContent=reader.readLine();
            send_message=fileContent.getBytes();
            client_socketOutputStream.write(send_message);
            
            System.out.println("send the message: "+new String(send_message));
            
            System.out.println("server close");
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
