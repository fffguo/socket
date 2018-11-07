package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 类功能描述：服务器线程处理类
 *
 * @author：刘富国
 * @createTime：2018/11/7 9:15
 */
public class ServerThread extends Thread {
    private Socket socket;


    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            //3.读取客户端发送信息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("接收到客户端发送的消息为：" + br.readLine());
            socket.shutdownInput();
            //4.推送客户端请求
            pw = new PrintWriter(socket.getOutputStream());
            pw.write("response");
            pw.flush();
            socket.shutdownOutput();
            //5.关闭连接
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (pw != null) {
                    pw.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
