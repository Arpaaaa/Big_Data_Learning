package MapTest;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(12);
        list.add(23);
        list.add(24);
        list.add(45);
        list.add(56);
        System.out.print(list);
        System.out.println();

        Collections.reverse(list);  //list 中的元素反转
        System.out.println(list);

        Collections.shuffle(list);  //list中元素随机排序
        System.out.println(list);

        Collections.sort(list); //list自然排序
        //Collections.sort(list, Comparator);   list定制排序，根据comparator来排序

        Collections.swap(list,2,4); //list 交换2，4位置的元素
        System.out.println(Collections.max(list));  //找到list中最大值，同理 min
        System.out.println(Collections.frequency(list, 56));

        List list1 = Arrays.asList(new Object[list.size()]);    //直接创建一个大小为list.size的对象，再把对象转为list

        Collections.copy(list1,list);   //把list中内容复制到 list1 中,但是需要满足list1.size>=list.size
        System.out.println(list1);

        List list2 = Collections.synchronizedList(list); //将list转换为线程安全的list
    }
}
