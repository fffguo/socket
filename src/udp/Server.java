package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 类功能描述：服务器端，先启动服务器端后启动客户端
 *
 * @author：刘富国
 * @createTime：2018/11/7 10:07
 */
public class Server {
    public static void main(String[] args) {
        try {
            /**
             * 接收客户端数据
             */
            //1.创建服务器端datagramSocket
            DatagramSocket socket = new DatagramSocket(18081);
            //2.创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            System.out.println("服务器已经启动，等待客户端发送数据：");
            //3.接收客户端发送的数据（接收数据报之前一直阻塞）
            int count = 1;
            while (true) {
                socket.receive(packet);
                ServerThread thread = new ServerThread(socket,packet,data);
                thread.start();
                System.out.println("客户端连接次数：" + count++);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
