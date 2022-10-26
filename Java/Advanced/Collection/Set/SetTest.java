package Big_Data_Learning.Java.Advanced.Collection.Set;

import Big_Data_Learning.Java.Primer.OOP.polymorphism.demo1.Person;

import java.util.*;

public class SetTest {

    public static void main(String[] args) {
        SetTest st = new SetTest();
        //st.test2();
        st.test4();
    }

    public void test1(){
        Set set = new HashSet<>();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new Person("arpat",23));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
    }
    public void test2(){
        Set lset = new LinkedHashSet();
        lset.add(1234);
        lset.add(456);
        lset.add("AA");
        lset.add(new Person("arpat",23));

        Iterator iterator = lset.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
    }
    public void test3(){
        TreeSet treeSet = new TreeSet();
        //Treeset 中的元素需要一致，具有共同的属性，由同一个类的对象
        treeSet.add(23);
        treeSet.add(43);
        treeSet.add(12);
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            //从小到大输出
            System.out.print(iterator.next());
        }
    }
    public void test4(){
        //anonymous innerclass
        Comparator com = new Comparator() {
            //按照年龄从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else {
                    throw new RuntimeException("Unmatched DataType");
                }
            }
        };
        TreeSet set = new TreeSet(com); //在创建时就会按照定制的compare方法进行排序放置
        set.add(new Person("tom",23));
        set.add(new Person("re",34));
        set.add(new Person("rewe",44));
        set.add(new Person("ewe",11));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            //从小到大输出
            System.out.println(iterator.next());
        }
    }
}
