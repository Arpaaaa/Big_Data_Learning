package demo1;

/* 泛型的使用 */

import java.util.*;

public class GenericTest1 {

    public static void main(String[] args) {



    }
    public static void test2(){
        /*如果定义了泛型类，实例化没有指明类型的泛型，则认为此泛型为Object类型
        * 如果Javabean定义了类是带泛型的，建议实例化时要指明类的泛型 */
        Order order = new Order();

        order.orderT = 123;
        order.orderT = "aa";
        //可以将泛型设为各种类
        Order<String> order1 = new Order<>();
        Order<Integer> order2 = new Order<>();
        Order<LinkedHashMap> order3 = new Order<>();
    }


    public static void test1(){
        //泛型不能是基本数据类型
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(10);

        //方式一
        for (Integer score:list){
            //避免了强转操作
            System.out.println(score);
        }

        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //在HashMap中使用泛型
        //Map<K,V>
        Map<String,Integer> map = new HashMap<>();

        map.put("a",1);
        map.put("b",2);

        Iterator<Map.Entry<String, Integer>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

}
