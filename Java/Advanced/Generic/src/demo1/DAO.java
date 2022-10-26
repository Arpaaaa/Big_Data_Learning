package demo1;

/*DAO:Database Access Object
* 在操作数据库时可以利用泛型
* Java中的一个类可以对应数据库中的一张表
* */
public class DAO<T> {

    public void add(T t){}

    public void update(int index,T t){}
}

class Student extends DAO<Integer>{
    //定义Student类
    Student s = new Student();

}
