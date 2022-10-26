package Demo2;

/*实现客户端向服务端发送文件，服务端将文件保存本地并输出 传输成功*/

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCP1 {

    public static void main(String[] args) {
        TCP1 tcp1 = new TCP1();
        try {
            tcp1.server();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //客户端
    public void client() throws Exception{

        //初始化socket对象
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);
        //获取socket输出流
        OutputStream os = socket.getOutputStream();


        //读入文件
        FileInputStream fis = new FileInputStream(new File("IO\\File\\Hello.txt"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //传输文件结束
        //关闭数据的输出
        socket.shutdownOutput();
        //接收反馈信息
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=is.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());

        fis.close();
        os.close();
        socket.close();
        is.close();
        baos.close();

    }
    public void server() throws Exception{

        ServerSocket ss = new ServerSocket(8899);

        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("IO\\File\\Hello2.txt"));

        byte[] buffer = new byte[1024];
        int len;
        /*is.read()是一个阻塞式的方法*/
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        //服务器端给客户端发送反馈
        OutputStream os = socket.getOutputStream();
        os.write("The message has been received ".getBytes());

        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();

    }
}
