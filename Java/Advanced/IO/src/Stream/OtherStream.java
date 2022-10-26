package Stream;

/* 其他流的使用
* 标准的输入、输出流
* 打印流
* 数据流
* 对象流
* */

import java.io.*;

public class OtherStream {

    public static void main(String[] args) {
        OtherStream os = new OtherStream();
        os.DataRO();

    }

    /**
     * system.in 标准的输入流
     * system.out 标准的输出流
     */
    public void SystemIO(){
        /*从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作直到输入e或exit退出
        * 方法一：scanner
        * 方法二：使用system.in -->转换流---> BufferedReader的readline()*/
        BufferedReader br = null;
        try {
            //转换流
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("Please Enter : ");
                String data = br.readLine();
                //以下if()的写法可以避免空指针的问题
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("Program Shutdown");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (br!=null){
                try {
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 数据流
     * DataInputStream
     * DataOutputStream
     * 作用：用于读取和写出基本数据类型的变量和类型
     */
    public void DataIOStream(){
        //创建数据流
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("IO\\File\\Hello2.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            dos.writeUTF("arpat");
            dos.flush();    //将内存数据写入文件
            dos.writeInt(23);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void DataRO(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("IO\\File\\Hello2.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //2.读取数据

        try {
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("name : "+name);
            System.out.println("Age : " + age);
            System.out.println("Is male? :" + isMale);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            dis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
