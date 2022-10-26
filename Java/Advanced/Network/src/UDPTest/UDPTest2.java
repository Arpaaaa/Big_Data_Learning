package UDPTest;

import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPTest2 {
    public static void main(String[] args) {
        UDPtest udPtest = new UDPtest();
        try {
            udPtest.sender();
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
