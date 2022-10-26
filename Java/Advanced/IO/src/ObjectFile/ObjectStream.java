package ObjectFile;

import java.io.*;
/*  对象流
 * 序列化：用ObjectOutputStream类保存基本类型数据或对象的机制，保存到磁盘中或通过网路传输出去
 * 反序列化：用ObjectInputStream类读取基本类型数据或对象机制
 *
 * 序列化可以将任何实现了Serializable接口的对象进行序列化（转化为字节数据）
 * 对象的序列化机制：将内存中的Java对象转换成与平台无关的二进制流，当其他程序或许这种二进制流时可以转化为对象 */


public class ObjectStream {

    public static void main(String[] args) {

        ObjectStream os = new ObjectStream();
        //os.testObjectStream();
        //os.testObjectInput();
        os.ObjectOutputStream();
    }


    public void testObjectStream(){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("IO\\File\\ObjectStr.dat"));

            oos.writeObject(new String("New day"));
            oos.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void testObjectInput(){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("IO\\File\\ObjectStr.dat"));

            Object obj = null;
            try {
                obj = ois.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            String str = (String) obj;
            System.out.println(str);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public void ObjectOutputStream(){
        /* 对象可以序列化的条件
        * 对象实现了Serializable */

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("IO\\src\\ObjectFile\\Gamer.txt"));
            oos.writeObject(new Gamer("arpat",100,"gun"));
            oos.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
