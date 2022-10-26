package Stream;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 写一个MyInput类 用来接收键盘输入的int,double,string,float...*/
public class MyInput {
    public static String nextString(){

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String data = "";
        try {
            data = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static int nextInt(){return Integer.parseInt(nextString());}

    public static double nextByte(){return Byte.parseByte(nextString());}

    public static double nextDouble(){return Double.parseDouble(nextString());}

    public static float nextFloat(){return Float.parseFloat(nextString());}
}
