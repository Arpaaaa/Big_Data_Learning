package PreparedStatement;

/*使用PrepareStatement实现对数据表的增删改查操作
* 增删改：无返回值
* 查：有返回值
* */

import JDBCUtils.JDBCUtiles;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class PreparedStatementTest {

    public static void main(String[] args) {
        PreparedStatementTest pst = new PreparedStatementTest();
        try {
            pst.testUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //向数据库中添加一条数据
    public void testInsert() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            InputStream is = PreparedStatementTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

            Properties props = new Properties();
            props.load(is);

            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String url = props.getProperty("url");
            String driverClass = props.getProperty("driverClass");

            Class.forName(driverClass);

            //获取连接
            connection = DriverManager.getConnection(url, user, password);
            //插入语句
            String sql = "INSERT INTO books (id, name, authors, price, note, num) " +
                    "VALUES (?,?,?,?,?,?);"; //?是占位符
            ps = connection.prepareStatement(sql);

            //填充占位符
            ps.setInt(1, 8);
            ps.setString(2, "Old Lake");
            ps.setString(3, "James Bound");
            ps.setInt(4, 100);
            //ps.setDate(5,new Date(2013));
            ps.setString(5, "novel");
            ps.setInt(6, 20);

            //执行preparedStatement
            ps.execute();
        }catch (Exception e){
            throw new RuntimeException();
        }finally {
            //资源的关闭
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //修改数据库表中数据
    public void testUpdate() {
        //获取数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtiles.getConnection();
            //预编译sql语句，返回Preparedstatement实例
            String sql = "UPDATE books SET name = ? WHERE id = ?;";

            ps = conn.prepareStatement(sql);
            //填充占位符
            ps.setString(1, "Old Old Old Lake");
            ps.setInt(2, 8);
            //执行
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        //关闭资源
        JDBCUtiles.closeResource(conn,ps);
    }

}
