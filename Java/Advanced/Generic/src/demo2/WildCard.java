package demo2;

import java.util.List;
/* 通配符的使用 ?
    类A是类B的父亲，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
* */

public class WildCard {

    public static void main(String[] args) {


    }

    public void test1(){
        List<?> list = null;
        List<Object> l1 = null;
        List<String> l2 = null;

        //使用通配符的List可以接收Object，String等多种类的引用
        list = l1;
        list = l2;

        l2.add("aa");
        //使用通配符后list不能再添加数据了
        //list.add();         //参数为 capture of ? e
        list.add(null);         //例外是 list中可以添加null

        list.get(0);    //读取数据是没问题的
    }

    /* 有限制条件的通配符
    * ? extends Person  类型限制最大为Person，Person的子类可以，父类不行
    * ? super Person    类型限制最小为Person，Person的父类可以，子类不行
    * */
    public void test2(){

        List<? extends Person>list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;

        list2 = list4;
        //list2 = list3;   list2 赋值类型要大于Person类型

        //读取数据
        Person l = list1.get(0);
        //写入数据不通过
        //list1.add(new Student());
        list2.add(new Person());    //list2 有超类限制，因此添加的数据不能超过Person类
        list2.add(new Student());

    }
}
