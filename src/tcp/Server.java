package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类功能描述：先启动服务器端，再启动客户端
 *
 * @author：刘富国
 * @createTime：2018/11/5 16:02
 */
public class Server {

    public static void main(String[] args) {
        try {
            //1.创建服务器socket  指定监听端口
            ServerSocket serverSocket = new ServerSocket(18080);
            //2.调用accept()开始监听，等待客户的连接
            System.out.println("---------服务器即将启动，等待客户端连接---------");
            int count = 1;
            //3.循环监听等待客户端的连接
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                System.out.println("客户端连接数：" + count++);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
