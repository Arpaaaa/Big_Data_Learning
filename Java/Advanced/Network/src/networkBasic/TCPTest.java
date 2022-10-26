package networkBasic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* 实现TCP 网络编程*/
public class TCPTest {

    public static void main(String[] args) {
        TCPTest tcpt = new TCPTest();
        try {
            tcpt.server();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //客户端
    public void client() throws IOException {
        Socket socket = null;
        OutputStream os=null;
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            //获取一个IP地址对象
            InetAddress inet = InetAddress.getByName("192.168.176.1");
            //新建一个socket对象并将IP地址和端口号输入
            socket = new Socket(inet, 8899);
            //获取socket输出流
            os = socket.getOutputStream();
            //向输出流写入数据
            os.write("Hello,I'm Siri".getBytes());


            //获取服务器端的确认数据
            //新建socket输入流
            /*is = socket.getInputStream();
            //读取输入流的数据
            byte[] buffer = new byte[20];
            int len;
            while ((len=is.read(buffer))!=-1){
                //写入baos数组中
                baos.write(buffer,0,len);
            }
            //输出baos数组内容
            System.out.println(baos.toString());

*/

            //处理异常及关闭资源
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (os!=null){
                try {
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            if (is!=null){
                try {
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (baos!=null){
                try {
                    baos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    public void server() throws IOException{
        InputStream is = null;
        ByteArrayOutputStream baos=null;
        Socket socket = null;
        ServerSocket ss = null;
        OutputStream os =null;
        try {
            //新建一个socket 并赋值
            ss = new ServerSocket(8899);
            socket = ss.accept();

            //创建socket输入流
            is = socket.getInputStream();
            //baos是一个数组，初始大小为32
            baos = new ByteArrayOutputStream();
            //读取数据的字节数组
            byte[] buffer = new byte[1024];
            int len;    //读取长度
            while ((len=is.read(buffer))!=-1){
                //向baos数组中写入数据
                baos.write(buffer,0,len);
            }
            //输出baos数组中的内容
            System.out.println(baos.toString());
            //获取socket端口号
            System.out.println(socket.getInetAddress().getHostName());

            /*//向客户端发送确认数据
            os = socket.getOutputStream();
            os.write("The Message has been received".getBytes());
*/

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

}
