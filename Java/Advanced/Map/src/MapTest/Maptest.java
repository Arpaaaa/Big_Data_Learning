package MapTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Maptest {
    public static void main(String[] args) {
        Maptest mt = new Maptest();
        Map map = new HashMap(12,0.5f);
        mt.test1();

        //map中的方法
        //put()，putAll(map)
        map.put("arpat",23);    //key:arpat value:23
        map.put(0,23);    //key:0 value:23
        map.put(1,18);      //当key相同时，会更新数据
        map.put(3,20);
        //remove(key)
        //map.remove(0);
        //clear(map)
        //map.clear();
        //System.out.println(map.get(3));
        map.containsKey("arpat");
        map.containsValue(23);
        map.isEmpty();
        //System.out.println(map.keySet());   //keyset 返回键数组

        //System.out.println(map.size());
        //System.out.println(map);


    }

    public void test1(){
        Map map = new HashMap();
        //map的键值对可以存放null值，但是hashtable不行
        map.put(1,123);
        map.put(2,null);
        //map 遍历方法
        Iterator iterator = map.entrySet().iterator();
        Iterator iterator1 = map.keySet().iterator();
        Iterator iterator2 = map.values().iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.println();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next());
        }
        System.out.println();
        while (iterator2.hasNext()){
            System.out.print(iterator2.next());
        }
    }
}
