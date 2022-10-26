package Connection;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

public class ConnectionTest {

    public static void main(String[] args) {
        ConnectionTest ct = new ConnectionTest();
        try {
            ct.dbQuary();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //连接数据库的方式一
    public void testConnection1() throws SQLException {

        //获取Driver的实现类对象
        Driver driver = new com.mysql.cj.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/myemployees";

        //将用户名和密码封装在properties中
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","arpat990708!!");

        //建立连接
        Connection conn = driver.connect(url,info);

        System.out.println(conn);
    }

    //连接数据库的方式二，对方式一的迭代
    //目的是在程序中不出现第三方的API,为了程序更好的可移植性
    public void testConnection2() throws Exception {
        //通过反射获取实现类对象
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        //提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/myemployees";

        //提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","arpat990708!!");

        //获取连接
        Connection connection = null;
        try {
            connection = driver.connect(url,info);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(connection);
    }

    //方式三：使用DriverMannger替换 Driver
    public void testConnection3() throws Exception{
        //通过反射获取实现类对象
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        //获取连接的基本信息
        String url = "jdbc:mysql://localhost:3306/myemployees";
        String usr = "root";
        String password = "arpat990708!!";
        //注册驱动
        DriverManager.registerDriver(driver);


        //获取连接
        Connection connection = DriverManager.getConnection(url, usr, password);
        System.out.println(connection);


    }
    //省略了Driver
    public void testConnection4() throws Exception{
        //获取连接的基本信息
        String url = "jdbc:mysql://localhost:3306/myemployees";
        String usr = "root";
        String password = "arpat990708!!";

        //加载driver
        Class.forName("com.mysql.cj.jdbc.Driver");  //Mysql可以省略，但是一般建议不省略
        /* 在加载Mysql的Driver类时，加载了该类的静态代码块，并自动加载了Driver，因此相比方式三
        * 我们可以省略手动加载driver的步骤*/

        //获取连接
        Connection connection = DriverManager.getConnection(url,usr,password);
        System.out.println(connection);
    }

    //方式五，最终版，将数据库需要的4个基本信息声明在配置文件中，通过读取配置文件的方式获取连接
    //优点：1. 如果需要更改数据库或用户直接修改properties文件即可，实现了代码与数据的分离，实现了解耦
    //     2. 如果需要更改配置文件，则避免了程序的重新打包
    public void testConnection5()throws Exception{
        //读取配置文件中的四个配置信息
        InputStream inputStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");//类加载器

        Properties props = new Properties();
        props.load(inputStream);

        String usr = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driverClass = props.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);


        //获取连接
        Connection connection = DriverManager.getConnection(url, usr, password);
        System.out.println(connection);

    }

    //与数据库建立连接并查询数据
    public void dbQuary() throws Exception{

        //读取配置文件的配置信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties props = new Properties();
        props.load(is);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driverClass = props.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);

        //获取连接
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement stat = connection.createStatement();
        ResultSet resultSet = stat.executeQuery(
                "SELECT salary FROM employees WHERE employee_id = 100"
        );
        if (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }
}
