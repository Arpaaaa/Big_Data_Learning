package MapTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        Properties pp = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pp.load(fis);   //加载流对应的文件
        String name = pp.getProperty("Name");
        String password = pp.getProperty("Password");
        System.out.println("name = " + name + " , password = " + password);
    }

}
