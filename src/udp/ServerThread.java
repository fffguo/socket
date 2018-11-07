package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 类功能描述：服务器线程处理类
 *
 * @author：刘富国
 * @createTime：2018/11/7 9:15
 */
public class ServerThread extends Thread {
    private DatagramSocket socket;
    private DatagramPacket packet;
    private byte[] data;


    public ServerThread(DatagramSocket socket,DatagramPacket packet,byte[] data) {
        this.socket = socket;
        this.packet = packet;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            //1.读取客户端发送的数据
            String info = new String(data, 0, packet.getLength());
            System.out.println("接收客户端发送信息为：" + info);
            byte[] resData = "响应数据".getBytes();
            DatagramPacket resPacket = new DatagramPacket(resData, resData.length, packet.getAddress(), packet.getPort());
            socket.send(resPacket);
            System.out.println("向客户端发送数据成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
