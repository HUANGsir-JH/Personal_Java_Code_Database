import java.net.*;

public class network_1 {
    public static void main(String[] args) {
    
    }
}

/**
 * 三要素：
 *      1. 软件架构：
 *          1. 网页端（browser），服务端（server）-> B/S
 *          2. 客户端（client），服务端（server）-> C/S
 *      2. IP地址：
 *          1. 网络地址（IP地址）->IPV4，IPV6
 *          2. 本机地址：127.0.0.1 （localhost）
 *      3. 端口：
 *          1. 每一个应用都有自己的端口，是一个唯一标识
 *          2. 端口号的范围是0~65535，其中0~1023是系统端口，1024~65535是用户端口
 *          3. 如果一个端口被占用，就无法使用，启动失败
 *      4. 网络协议：
 *          1. TCP协议：
 *              1. 需要建立连接，传输效率较低但是安全，少丢包
 *              2. 连接（三次握手）： C-S -> S-C -> C-S
 *                  1. 第一次握手：客户端发送 SYN,客户端向服务器发送一个带有 SYN 标志的数据包，表示请求建立连接。
 *                      这个包包含一个随机生成的序列号 Seq = x。客户端状态：SYN-SENT
 *                  2. 第二次握手：服务器发送 SYN-ACK,服务器收到客户端的 SYN 包后，返回一个 SYN-ACK 包，表示同意建立连接。
 *                      服务器的包包含两个信息：
 *                          SYN 标志，表示同意建立连接。
 *                          ACK 标志，确认客户端的序列号 x，即 Ack = x + 1。
 *                      服务器也生成一个自己的序列号 Seq = y。服务器状态：SYN-RECEIVED
 *                  3. 第三次握手：客户端发送 ACK,客户端收到服务器的 SYN-ACK 包后，发送一个 ACK 包给服务器，表示确认。
 *                      这个包包含：
 *                          Ack = y + 1，确认服务器的序列号。
 *                      该包不再包含 SYN 标志，只包含 ACK。客户端状态：ESTABLISHED 服务器状态：ESTABLISHED
 *              3. 断开（四次挥手）：
 *                   "
 *                      第一次和第二次挥手：客户端请求关闭连接，服务器确认收到关闭请求。
 *                      第三次和第四次挥手：服务器发送关闭请求，客户端确认收到关闭请求。
 *                  "
 *                  1. 第一次挥手：客户端发送 FIN，客户端向服务器发送一个带有 FIN 标志的数据包，
 *                      表示客户端请求关闭连接，停止发送数据。客户端进入 FIN-WAIT-1 状态。
 *                  2. 第二次挥手：服务器发送 ACK，服务器收到客户端的 FIN 包后，发送一个 ACK 包，确认收到关闭请求。
 *                      此时服务器仍然可以继续发送数据。服务器进入 CLOSE-WAIT 状态，客户端进入 FIN-WAIT-2 状态。
 *                  3. 第三次挥手：服务器发送 FIN,服务器处理完剩余的数据后，也向客户端发送一个带有 FIN 标志的数据包，
 *                      表示服务器也准备关闭连接。服务器进入 LAST-ACK 状态。
 *                  4. 第四次挥手：客户端发送 ACK,客户端收到服务器的 FIN 包后，发送一个 ACK 包，表示确认。
 *                      客户端进入 TIME-WAIT 状态，并等待一段时间（通常为 2 * 最大报文段生存时间），
 *                      以确保服务器收到 ACK 包后再完全关闭连接。最终，客户端和服务器都进入 CLOSED 状态，连接关闭。
 *          2. UDP协议：
 *              1. 无连接，无需建立连接，只需发送数据包即可
 *              2. 效率高，但是丢包率高，不是很安全
 */


/**
 * UDP:
 *      1. DatagramSocket ->  用于发送和接受数据
 *          构造：DatagramSocket socket = new DatagramSocket(); -> 空参自动分配端口
 *          构造：DatagramSocket socket = new DatagramSocket(int port); -> 指定端口
 *          方法：void send(DatagramPacket packet) -> 发送数据包
 *               void send(DatagramPacket packet, int timeout) -> 发送数据包，设置超时时间
 *               void receive(DatagramPacket packet) -> 接收数据包
 *               void receive(DatagramPacket packet, int timeout) -> 接收数据包，设置超时时间
 *               void close() -> 关闭
 *      2. DatagramPacket -> 用于封装要发送或接收的数据。
 *          构造：DatagramPacket(byte[] buf, int length) -> 接收数据
 *          构造：DatagramPacket(byte[] buf, int length, InetAddress address, int port) -> 发送数据
 *                              要发送的数据，数据长度，目的地址，目的端口
 *          方法：InetAddress getAddress() -> 获取目的地址
 *               int getPort() -> 获取目的端口
 *               byte[] getData() -> 获取要发送的数据
 *               int getLength() -> 获取要发送的数据的长度
 *               void setData(byte[] data) -> 设置要发送的数据
 *               void setLength(int length) -> 设置要发送的数据的长度
 *               void setAddress(InetAddress address) -> 设置目的地址
 *               void setPort(int port) -> 设置目的端口
 *
 *
 */
class udp_sent{
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] bytes = "hello,world".getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 8080;
            DatagramPacket packet =new DatagramPacket(bytes,bytes.length,address,port);
            socket.send(packet);
            System.out.println("发送成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
}


// 先开received，再开sent
class udp_received{
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(8080)) { // 接收端需要指定端口！！！
            byte[] bytes = new byte[1024];// 接收数据
            DatagramPacket packet=new DatagramPacket(bytes, bytes.length);
            // 创建接收数据的数据包
            socket.receive(packet);
            byte[] data = packet.getData();
            int length = packet.getLength();
            String message = new String(data, 0, length);
            System.out.println(message);
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            System.out.println(address+"--"+port);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
