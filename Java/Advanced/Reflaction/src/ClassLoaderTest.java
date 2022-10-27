package Big_Data_Learning.Java.Advanced.Reflaction.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoaderTest clt = new ClassLoaderTest();
        clt.test2();
    }

    public void test1(){
        //对于自定义类，使用系统类加载器加载
        ClassLoader cl =  ClassLoaderTest.class.getClassLoader();
        System.out.println(cl);

        ClassLoader cl2 = cl.getParent();
        System.out.println(cl2);

        ClassLoader cl3 = String.class.getClassLoader();
        System.out.println(cl3);    //返回null
    }

    //Properties:用来读取配置文件
    //TODO:使用properties读取配置文件
    public void test2() throws Exception {
        Properties props = new Properties();
        FileInputStream fis = null;
        fis = new FileInputStream("Java\\Advanced\\Reflaction\\src\\propsTest.properties");

        try {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String user = props.getProperty("user");
        String password = props.getProperty("password");

        System.out.println("User: "+user+"password :"+password);

        try {
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
