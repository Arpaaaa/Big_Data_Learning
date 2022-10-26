# Driver数据库驱动

# Connection 数据库连接


# 使用PreparedStatement 实现CRUD操作
在`java.sql`包中有3个接口定义了对数据库的调用的不同方式
* statement: 用于执行**静态SQL语句**并返回所生成的结果
  * 弊端：存在SQL注入问题，影响数据库的安全
* PreparedStatement :SQL语句被编译并存储在此对象中，可以使用此对象来多次执行sql语句
* CallableStatement: 用于执行SQL存储过程

