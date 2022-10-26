package networkBasic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    /* InetAddress类 标识 IP地址
    * IP: Internet上计算机的唯一标识
    * 域名：www.baidu.com, www.mi.com www.sina.com
    * 使用DNS来解析域名到IP地址
    * 本地回路地址：127.0.0.1 对应 localhost
    * */

    public static void main(String[] args) {

        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            //根据域名获取IP地址
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            //获取本机地址
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            inet1.getHostName();
            inet2.getHostAddress();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

}
