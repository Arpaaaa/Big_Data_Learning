package JDBCUtils;
/* 操作数据库的工具类 */


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtiles {
    /**
     * 获取数据库的连接
     * @return connection
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //读取配置文件中的四个配置信息
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");//类加载器
        //加载Properties
        Properties props = new Properties();
        props.load(inputStream);

        String usr = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driverClass = props.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);
        //获取连接
        return DriverManager.getConnection(url, usr, password);
    }

    /**
     * 关闭资源方法
     * @param connection
     * @param ps
     */
    public static void closeResource(Connection connection, Statement ps){
        try {
            if (ps!=null)
                ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if (connection!=null)
                connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
