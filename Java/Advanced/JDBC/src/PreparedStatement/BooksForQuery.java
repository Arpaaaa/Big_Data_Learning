package PreparedStatement;

import JDBCUtils.JDBCUtiles;
import com.sun.source.tree.ReturnTree;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对Customer表的通用查询操作
 */
public class BooksForQuery {
    public static void main(String[] args) {
        BooksForQuery bfq = new BooksForQuery();
        String sql = "select id,name,authors,price,pubdate,note,num from books where id=?";
        Books book1 = bfq.booksForQuery(sql, 7);
        System.out.println(book1);
    }
    /*ORM编程思想：object relational mapping
    * 一个数据表对应一个Java类，表中一个记录对应类的一个对象*/
    public class Books{
        int id;
        String name;
        String authors;
        double price;
        Date pubdate;
        String note;
        int num;


        public Books() {
        }

        public Books(int id, String name, String authors, double price, Date pubdate, String note, int num) {
            this.id = id;
            this.name = name;
            this.authors = authors;
            this.price = price;
            this.pubdate = pubdate;
            this.note = note;
            this.num = num;
        }

        /**
         * 获取
         * @return id
         */
        public int getId() {
            return id;
        }

        /**
         * 设置
         * @param id
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * 获取
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * 设置
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 获取
         * @return authors
         */
        public String getAuthors() {
            return authors;
        }

        /**
         * 设置
         * @param authors
         */
        public void setAuthors(String authors) {
            this.authors = authors;
        }

        /**
         * 获取
         * @return price
         */
        public double getPrice() {
            return price;
        }

        /**
         * 设置
         * @param price
         */
        public void setPrice(double price) {
            this.price = price;
        }

        /**
         * 获取
         * @return pubdate
         */
        public Date getPubdate() {
            return pubdate;
        }

        /**
         * 设置
         * @param pubdate
         */
        public void setPubdate(Date pubdate) {
            this.pubdate = pubdate;
        }

        /**
         * 获取
         * @return note
         */
        public String getNote() {
            return note;
        }

        /**
         * 设置
         * @param note
         */
        public void setNote(String note) {
            this.note = note;
        }

        /**
         * 获取
         * @return num
         */
        public int getNum() {
            return num;
        }

        /**
         * 设置
         * @param num
         */
        public void setNum(int num) {
            this.num = num;
        }

        public String toString() {
            return "Books{id = " + id + ", name = " + name + ", authors = " + authors + ", price = " + price + ", pubdate = " + pubdate + ", note = " + note + ", num = " + num + "}";
        }
    }

    public void test1(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtiles.getConnection();

            String sql = "SELECT id,name,authors,price,pubdate,note,num FROM books " +
                    "WHERE id = ?";
            ps = conn.prepareStatement(sql);
            //填充占位符
            ps.setObject(1,4);
            //执行并返回结果集
            resultSet = ps.executeQuery();
            //处理结果集
            if (resultSet.next()) {      //next()判断结果的下一条是否有数据，如果有数据则返回true并指针下移
                //获取当前数据的各字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String authors = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                Date pubdate = resultSet.getDate(5);
                String note = resultSet.getString(6);
                int num = resultSet.getInt(7);

                //字段输出
                //Object[] data = new Object[]{id,name,authors,price,pubdate,note,num};
                Books book1 = new Books(id, name, authors, price, pubdate, note, num);
                System.out.println(book1.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtiles.closeResource(conn,ps,resultSet);
        }
    }

    /**
     *
     */
    public Books booksForQuery(String sql,Object...args){
        //初始化资源
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtiles.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            //获取结果集的元数据 : ResultSetMetaData
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //用元数据获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            if (resultSet.next()) {
                Books book = new Books();   //新建一个books对象
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResource(connection,ps,resultSet);
        }
        return null;
    }
}
