package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 类功能描述：
 *
 * @author：刘富国
 * @createTime：2018/11/7 10:14
 */
public class Client {
    public static void main(String[] args) {
        try {
            /**
             * 向服务器发送信息
             */
            //1.定义服务器地址 端口 数据
            InetAddress address = InetAddress.getByName("localhost");
            byte[] data = "数据".getBytes();
            //2.创建数据报
            DatagramPacket packet = new DatagramPacket(data, data.length, address, 18081);
            //4.向服务器发送数据
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            System.out.println("向服务器发送数据成功！");
            /**
             * 接收服务器响应信息
             */
            byte[] reqData = new byte[1024];
            DatagramPacket reqPacket = new DatagramPacket(reqData, reqData.length);
            socket.receive(reqPacket);
            String info = new String(reqData, 0, reqPacket.getLength());
            System.out.println("接收服务器的响应数据为：" + info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
