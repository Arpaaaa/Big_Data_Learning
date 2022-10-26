package Big_Data_Learning.Java.Advanced.Collection.List;

import Big_Data_Learning.Java.Primer.OOP.polymorphism.demo1.Person;

import java.util.*;

/*Collection Interface Method
* @author arpat
* @create 2022.10.10
* */
public class collectionDemo1 {
    public static void main(String[] args) {
        collectionDemo1 collectionDemo1 = new collectionDemo1();
        //collectionDemo1.test1();
        collectionDemo1.test2();
    }
    public void test1(){
        //集合collection 可以存储Object对象类
        Collection<Object> collection = new ArrayList<>();
        Collection<Object> coll1 = new ArrayList<>();

        //1. add(object e)
        collection.add(123);  //自动装箱,Integer
        collection.add(new String("Tom"));
        collection.add(false);  //Boolean
        coll1.add("ab");
        coll1.add(32);
        collection.addAll(coll1);

        //we can also add self-build objects like person,student etc
        //2.contains(Object obj)
        boolean contains = collection.contains(false);
        System.out.println(contains);
        collection.add(new Person());
        boolean cs = collection.contains(new Person());  //在判断是否含有Person类对象时，会调用Person类中的equals方法，并把集合中的元素代入equals方法的形参

        /*3. containsAll(Collection<E> c)
        * 传一个Collection c对象并判断c是否在方法调用的集合中
        * */
        boolean call = collection.containsAll(coll1);  //判断collection中是否都包含coll1中的数据

        //4.remove(Object obj)
        collection.remove(123); //移除123对象
        //5. removeAll(Collection<E> c)
        collection.removeAll(coll1);    //移除collection中与coll1 共有的部分，差集操作

        //6.retainAll(Collection<E> c)
        collection.retainAll(coll1); //求collection和coll1的交集,共有部分

        //7.equals(Object obj) 判断两个对象是否相同

        //8.hashCode() 返回当前对象的哈希值

        //9.toArray() 将集合转换为数组
        Object[] arr = collection.toArray();    //将集合collection转化为集合并让arr对象引用
        // 将数组转化为集合 Array.asList()
        List<String> list = Arrays.asList("ab","bd");

        //size()
        int size = collection.size();
        System.out.println(size);
//        collection.clear();
//        System.out.println(collection.isEmpty());
    }
    public void iterator(){
        Collection<Object> collection = new ArrayList<>();

        collection.add(123);
        collection.add("ab");
        collection.add(new Person("arpat",23));

        //iterator 遍历接口 iterator对象称为迭代器，主要用于遍历collection集合中的元素
        Iterator<Object> iterator = collection.iterator();
        //方式1
        /*for (int i = 0; i < collection.size(); i++) {
            iterator.next();
        }*/
        //方式2   常用
        while (iterator.hasNext()){     //判断迭代器有没有下一个元素
            System.out.println(iterator.next());
        }
    }

    @Test2
    public void test2(){
        Collection<Object> col = new ArrayList<>();
        col.add(123);
        col.add("Tom");
        col.add("om");
        col.add("To");

        Iterator<Object> iterator = col.iterator();     //创建迭代器对象
        while (iterator.hasNext()){
            //迭代器下一个对象obj
            Object obj = iterator.next();
            //如果下一个迭代对象是“Tom”
            if ("Tom".equals(obj)){
                //删除迭代器中的元素
                //注意：得现有iterator.next()才能有iterator.remove(),不能直接上来就remove
                iterator.remove();
            }
        }

        //用增强for循环来遍历
        for (Object o : col) {
            System.out.println(o);
        }
        //forEach 方法
        col.forEach(System.out::print);

    }
}
