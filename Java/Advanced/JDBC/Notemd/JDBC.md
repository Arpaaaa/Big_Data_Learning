# JDBC 

## Driver数据库驱动

1.DriverManager 类

Driver Manager类用于加载JDBC驱动并且创建与数据库的连接。 在Driver Manager类中，定义了两个比较重要的静态方法

`registerDriver(Driver driver)`

`static Connection getConnection(String url,String user,String pwd)  // establishes a connection to the given database and returns a Connection object`

## Connection 数据库连接

1. Connection 接口

Connection接口代表Java程序与数据库之间的连接，该接口中的方法有

`getMetaData()  //返回数据库中的元数据`

`createStatement() //用来创建一个statement对象将sql语句发送到数据库`

`prepareStatement(String sql)  //创建一个prepareStatement对象将参数化sql语句发送到数据库`

`prepareCall(String sql)  //创建一个CallableStatement对象来调用数据库存储过程`

2. 创建Connection

`Connection connection = DriverManager.getConnection(url,user,password);`

## 使用PreparedStatement 实现CRUD操作
在`java.sql`包中有3个接口定义了对数据库的调用的不同方式
* statement: 用于执行**静态SQL语句**并返回所生成的结果
  * 弊端：存在SQL注入问题，影响数据库的安全
* PreparedStatement :SQL语句被编译并存储在此对象中，可以使用此对象来多次执行sql语句
* CallableStatement: 用于执行SQL存储过程

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PS {
  public void test() {
    //第一步获取连接
    Connection connection = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
    //写sql查询
    String sql = "select * from library where id = ?";
    //初始化preparedStatement
    PreparedStatement ps = connection.prepareStatement(sql);
    //填充占位符
    ps.setObject(1, 2);
    //返回结果集
    ResultSet resultSet = ps.executeQuery();
  }
}
```



## 对结果集的处理

* ORM (object relational mapping)编程思想：一个数据表对应一个Java类，表中一行记录对应一个对象，记录中的一个字段对应对象的一个属性
因此我们可以根据返回结果集创建对象

```java
import JDBCUtils.JDBCUtiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class ResultSet {
  public void testResultSet() {
    Connection connection = JDBCUtiles.getConnection();
    String sql = "select * from library where id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    java.sql.ResultSet resultSet = ps.executeQuery();

    //获取结果集元数据
    ResultSetMetaData metaData = resultSet.getMetaData();
    //获取结果集的列数
    int columnCount = metaData.getColumnCount();
    if (resultSet.next()) {
      PreparedStatement.BooksForQuery.Books books = new PreparedStatement.BooksForQuery.Books();
      for (int i = 0; i < columnCount; i++) {
        //获取结果集中的对象
        Object columnValue = resultSet.getObject(i + 1);
        //获取每个列的列名
        String columnName = rsmd.getColumnName(i + 1);
        //给book对象指定columnName属性赋值为columnValue--利用反射机制
        Field field = Books.class.getDeclaredField(columnName); //获取Books类的属性Fields
        field.setAccessible(true);  //防止属性不可访问，将访问设为true
        field.set(book, columnValue);    //将book对象的field属性设为columnValue值
      }
      return book;
    }
  }
}
```