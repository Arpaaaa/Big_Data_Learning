package networkBasic;

import java.io.IOException;

public class TCPTest2 {

    public static void main(String[] args) {
        TCPTest tcpTest = new TCPTest();

        try {
            tcpTest.client();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
