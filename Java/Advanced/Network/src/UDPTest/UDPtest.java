package UDPTest;

import com.sun.source.tree.Scope;

import java.io.IOException;
import java.net.*;

public class UDPtest {
    public static void main(String[] args) {
        UDPtest udPtest = new UDPtest();
        try {
            udPtest.receiver();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }


    public void sender() throws SocketException, UnknownHostException {

        DatagramSocket socket = new DatagramSocket();
        String str = "This is UDP test";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,8899);
        try {
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        socket.close();

    }
    public void receiver() throws SocketException {
        DatagramSocket socket = new DatagramSocket(8899);

        byte[] buffer = new byte[100];

        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        try {
            socket.receive(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
