package cn.atsuc.network;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 * @author atsuc
 * @date 2024/6/11 20:03
 * @email s202011105851@163.com
 * @description  UDPd协议的网络编程
 *
 * URL网络编程
 * 1.URL:统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 *  http://localhost:8080/examples/beauty.jpg?username=Tom
 *  协议   主机名    端口号  资源地址           参数列表
 */
public class UDPTest {

    @Test
    public void testSend() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str = "i am udp dump";
        byte[] datas = str.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, localHost, 9090);

        socket.send(packet);
        socket.close();
    }

    @Test
    public void testReceive() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }

    @Test
    public void testSource() {
        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");
            System.out.println(url.getProtocol()); // URL协议名
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTarget() throws IOException {
        HttpURLConnection connection = null;
        InputStream in = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");

            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            in = connection.getInputStream();
            fos = new FileOutputStream("D:\\code\\github\\DayilyCode\\JavaBase\\src\\main\\java\\cn\\network\\beauty.jpg");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            System.out.println("download success ... ");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            in.close();
            if (fos != null) {
                fos.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
