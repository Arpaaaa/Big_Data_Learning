package Big_Data_Learning.Java.Advanced.Collection.List;

import Big_Data_Learning.Java.Primer.OOP.polymorphism.demo1.Person;

import java.util.*;

public class listTest {
    //面试题：ArrayList,LinkedList,Vector三者异同？
    /*相同：三个都实现了List接口，存储数据的特点相同（有序，可重复）
    * 不同：ArrayList是List接口的主要实现类*/
    public static void main(String[] args) {
        listTest lt = new listTest();
        lt.test1();
    }
    public void test1(){
        ArrayList list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person());

        //System.out.println(list);
        //void add(int index,obj e)
        list.add(2,"bb");
        //void addAll(Collection c)
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);
        //get(int index)
        list.get(2);
    }
    public void test2(){
        ArrayList list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person());

        //indexof(obj) 返回元素的索引，首次出现的位置，若不存在则返回-1
        list.indexOf(456);
        //lastindexof(obj)
        list.lastIndexOf("AA");
        //remove(int index) 删除索引为index的元素
        list.remove(2);
        //set(int index,obj e)
        list.set(1,000);
        //sublist(int fromindex,int toIndex) 返回从FromIndex到toIndex的子列表，左闭右开
        list.subList(3,5);
    }
    public void test3(){
        ArrayList list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add("AA");
        //List遍历方法
        //1. 迭代器方法
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){         //在下一个元素存在的情况下，输出下一个元素hasnext()返回boolean值
            System.out.println(iterator.next());
        }
        //2. 增强for循环方法
        for (Object o : list) {
            System.out.println(o);
        }
        //3. 普通for循环方法
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
