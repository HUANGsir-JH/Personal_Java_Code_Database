import java.io.*;
import java.net.*;

public class network1_1 {
    public static void main(String[] args) {
    
    }
}
// 客户端
class udp_client_send_request{
    public static void main(String[] args) {
        try (DatagramSocket ClientSocket=new DatagramSocket()){
            // 向服务端发送请求（本机）
            InetAddress address=InetAddress.getByName("127.0.0.1");
            
            String request="ask for file content";
            byte[] bytes=request.getBytes();
            // 创建并且发送数据包
            DatagramPacket packet=new DatagramPacket(bytes,bytes.length,address,8080);
            ClientSocket.send(packet);
            System.out.println("client send request: "+request+" and success");
            
            byte[] receive=new byte[1024];
            // 接收服务端的响应
            DatagramPacket receivePacket=new DatagramPacket(receive,receive.length);
            ClientSocket.receive(receivePacket);
            // 将服务端的响应转化为字符串
            String response=new String(receivePacket.getData(),0,receivePacket.getLength());
            
            // 数据较多时：
            /*
                // 接收服务器返回的数据包
                byte[] receiveBuffer = new byte[1024];
                StringBuilder receivedData = new StringBuilder();
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
    
                // 循环接收数据包，直到数据结束（没有更多数据）
                while (true) {
                    clientSocket.receive(receivePacket);
                    String data = new String(receivePacket.getData(), 0, receivePacket.getLength());
    
                    // 检查是否为空数据包，若为空则表示传输结束
                    if (data.isEmpty()) {
                        break;
                    }
    
                    // 拼接接收到的数据
                    receivedData.append(data);
                }
    
                // 输出接收到的完整文件内容
                System.out.println("客户端收到文件内容：\n" + receivedData);
             */
            System.out.println("server response: "+response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// 服务端
class udp_server_send_response{
    public static void main(String[] args) {
        try (DatagramSocket ServeSocket=new DatagramSocket(8080)){
            byte[] receive=new byte[1024];
            System.out.println("waiting for client request...");
            // 接收客户端的请求
            DatagramPacket receivePacket=new DatagramPacket(receive, receive.length);
            ServeSocket.receive(receivePacket);
            
            String request=new String(receivePacket.getData(),0,receivePacket.getLength());
            System.out.println("server receive client's request: "+request);
            
            // 读取文件内容
            File file=new File("D:\\IDEA_Java\\Java_Learning\\Network_Programming\\FileToSend.txt");
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String fileContent=reader.readLine();
            reader.close();
            
            // 向客户端发送文件内容
            byte[] send=fileContent.getBytes();
            InetAddress client_address=receivePacket.getAddress();
            int client_port=receivePacket.getPort();
            DatagramPacket sendPacket=new DatagramPacket(send,send.length,client_address,client_port);
            ServeSocket.send(sendPacket);
            
            // 数据较多时：
            /*
                // 读取 inputFile.txt 文件的所有内容
                File file = new File("D:\\UDP_Example\\inputFile.txt");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder fileContent = new StringBuilder();
                String line;
    
                // 逐行读取文件内容并拼接
                while ((line = reader.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }
                reader.close();
    
                // 发送文件内容给客户端
                byte[] sendBuffer = fileContent.toString().getBytes();
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
    
                // 将文件内容分块发送，避免超出 UDP 数据报大小限制
                int offset = 0;
                int packetSize = 1024; // 每次发送的最大字节数
                while (offset < sendBuffer.length) {
                    int length = Math.min(packetSize, sendBuffer.length - offset);
                    DatagramPacket sendPacket = new DatagramPacket(sendBuffer, offset, length, clientAddress, clientPort);
                    serverSocket.send(sendPacket);
                    offset += length;
                }
    
                System.out.println("服务器发送文件内容完成。");
             */
            
            System.out.println("server send file content success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}