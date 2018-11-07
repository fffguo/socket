import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {

//    public static void main(String[] args) throws UnknownHostException {
//        InetAddress inetAddress = InetAddress.getLocalHost();
//        InetAddress inetAddress = InetAddress.getByName("10.167.10.23");
//        System.out.println(Arrays.toString(inetAddress.getAddress()));
//        System.out.println(inetAddress.getCanonicalHostName());
//        System.out.println(inetAddress.getHostAddress());
//        System.out.println(inetAddress.getHostName());
//    }

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = bufferedReader.readLine();
        while (str != null && !str.isEmpty()) {
            System.out.println(str);
            str = bufferedReader.readLine();
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

    }
}
