package tcp;

import java.io.*;
import java.net.Socket;

/**
 * 类功能描述：客户端
 *
 * @author：刘富国
 * @createTime：2018/11/5 16:03
 */
public class Client {

    public static void main(String[] args) {
        try {
            //1.创建客户端socket，指定服务器地址和端口
            Socket socket = new Socket("127.0.0.1", 18080);
            //2.向服务器发送信息
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write("request");
            pw.flush();
            socket.shutdownOutput();
            //3.读取服务器推送信息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("接收到服务器推送的消息为：" + br.readLine());
            socket.shutdownInput();
            //4.关闭连接
            br.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
