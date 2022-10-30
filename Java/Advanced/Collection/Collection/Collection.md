# Collection

# Collection集合

## Collection 主要方法

$$
add(obj), addAll(collection), size(), isEmpty(), clear(); contains(obj),containsAll(collection), reomve(obj), removeAll(collection), retainsAll(collection), equals(obj), hashCode(), toArray(), iterator();
$$

## Collection和数组的转化

1. 集合→数组：**toArray()**
2. 数组→集合：**Arrays.asList()**

主要两个子接口List和set，包括其主要方法

- 在collection中添加对象obj时，需要重写equals 方法
    - 为什么要重写？ 答：在Object类中的equals方法实际是比较两个对象在内存中的地址，如果内存地址不同则返回false。在实际开发中，例如定义Person类，两个Person对象的名称、年龄等都相同但是内存地址不同，我们认为两个对象相同，但是equals方法会返回false，因此我们要重写equals 来重新比较两个Person对象。

```java
//collection 创建
public class collectionDemo1 {
    public static void main(String[] args) {
        collectionDemo1 collectionDemo1 = new collectionDemo1();
        collectionDemo1.test1();
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
				// 对象的contains判断
				collection.add(new Person());
        collection.contains(new Person());  //在判断是否含有Person类对象时，会调用Person类中的equals方法，并把集合中的元素代入equals方法的形参
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
}
```

 

- 迭代器 Iterator

```java
public class Iterator {
    public void iterator() {
        Collection<Object> collection = new ArrayList<>();

        collection.add(123);
        collection.add("ab");
        collection.add(new Person("arpat", 23));

        //iterator 遍历接口 iterator对象称为迭代器，主要用于遍历collection集合中的元素
        Iterator<Object> iterator = collection.iterator();
        //方式1
        /*for (int i = 0; i < collection.size(); i++) {
            iterator.next();
        }*/
        //方式2   常用
        while (iterator.hasNext()) {     //判断迭代器有没有下一个元素
            System.out.println(iterator.next());
        }
        //错误方式1
        while (iterator.next() != null) {
            System.out.println(iterator.next());   //会跳跃输出
        }
        //错误方式2
        while (collection.iterator.hasnext()) {
            System.out.println(collection.iterator.next());   //重复输出第一个元素
        }
        //collection每一次调用iterator都会创建iterator对象

    }
}
```

其他迭代方法

1. for循环
2. for增强循环

```java
for(Obejct o:collection){
		system.out.print(o);
}
```

1. Java 8 新特性 forEach()方法

```java
//源码
default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
//应用
collection.forEach(system.out::print)
//对集合中的每一个元素进行system.out::print操作
```

## List 接口

- 三个实现类 **ArrayList, LinkedList, Vector**
    1. **ArrayList-数组**
        1. 作为list接口的主要实现类，线程不安全，性能在三者中最好。
        2. 在底层使用Object类数组存储 `Object[]`
        3. 频繁插入、删除操作效率较低
        
        源码分析
        
        1. `**ArrayList list = new ArrayList();**` 在底层创建默认长度为10 的Object[]数组elementData
        2. **`list.add(123) ;`** elementDate = new Integer[123] 在底层数组第一位存123
        3. 如果添加之后底层数组容量不够，则会自动扩容为原来的1.5倍同时将原有数组数据复制到扩容后的数组中
        4. 在构造ArrayList时应尽量采用有参构造器，避免了底层数组的频繁扩容
        
    2. **LinkedList-链表**
        1. 底层使用双向链表存储，对于频繁插入、删除操作效率较高
        
        源码分析
        
        1. LinkedList底层是一个一个的节点Node，`**linkedList list = new LinkedList()**`
        
        ```java
        private static class Node<E> {
                E item;
                Node<E> next;  //向后指针
                Node<E> prev;  //向前指针
        
                Node(Node<E> prev, E element, Node<E> next) {
                    this.item = element;
                    this.next = next;
                    this.prev = prev;
                }
            }
        ```
        
        1. 添加元素，在底层创建一个新Node，将添加元素封装在Node中并且链接到LinkedList上；
        2. 底层是双向链表，有next和prev变量（c++中的指针）分别指向下一个元素和前一个元素
    3. **Vector**
        1. 作为list接口的古老实现类，线程安全，但是性能较差
        2. 底层使用Object类数组
        3. 底层和ArrayList类似，扩容方法较有区别(扩容数组容量是原数组容量的两倍，ArrayList是1.5倍），目前已经很少使用
- **List接口中的常用方法**
    1. Collection集合中继承的方法
    2. 一些有关于**索引**的方法,常用方法：增-add,删-remove ,改-set, 查-get，长度-size、遍历-Iterator\增强for循环
       
        ```java
        //void add(int index,obj e)
        list.add(2,"bb");
        //void addAll(Collection c)
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);
        //get(int index)
        list.get(2);
        public void test2(){
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
        ```
        
        - 需要注意的是 **remove**方法，有**`remove(int index)`** 和 `**remove(Obj)**`两种删除方法，传递的参数不同

面试题：ArrayList,LinkedList,Vector三者异同？

- 相同：三个都实现了List接口，存储数据的特点相同（有序，可重复）
- 不同：ArrayList是List接口的主要实现类，底层用Object数组存储……

## Set 接口

- 存储数据的特点：元素无序、不可重复的集合
    - **无序性**：不等于随机性，存储的数据在底层数组中并非按照数组索引顺序添加，根据添加元素的哈希值HashCode来决定放在底层数组的位置
    - **不可重复性：**保证添加元素按照equals方法判断时，不能返回true。即：相同的元素只能添加一个。
- 添加元素的过程：以HashSet为例
    - 计算添加元素的哈希值 HashCode(),并且根据哈希值决定元素存储的位置，**哈希值需要唯一**
    - 如果元素a添加到数组时，已经有元素b占用了a的位置，那么需要分两种情况
        - a和b的哈希值不一样，那么根据拉链法，将a链接到b上，创建一个b和a的链表，在JDK8中b→a;
        - a和b的哈希值一样，需要调用equals()方法来判断是否相同，若相同则添加失败，若不相同则同上创建链表
        - 向Set中添加的数据，其所在类的equals()方法和HashCode()方法一定要重写，保证重写的equals()和HashCode()的一致性，相等的对象具有相等的HashCode
        - HashCode()重写，HashCode()方法主要是通过散列函数用属性来计算存放的地址
        - **小技巧：直接快捷键生成类的equals方法和HashCode方法！**
    
    ![HashSet添加](D:\JAVA\Big_Data_Learning\Java\Advanced\Collection\Collection\Untitled.png)
    
- HashSet 是Set的主要实现类，底层是 **数组+链表**
    1. **HashSet: 线程不安全，可以存储NULL值**
       
        底层存储用**数组**实现
        
        1. **LinkedHashSet：作为HashSet子类，使得遍历其内部数据时可以按照添加的顺序遍历**
            1. 在原有的HashSet的基础上，对每一个元素新增了双向链表的功能，因此可以通过添加的顺序进行遍历。底层数组中元素的结构为：|prev |data| next| 
    2. **SortedSet**
        1. **TreeSet：使用红黑树存储，存储对象需要是同一个类的对象，可以按照添加元素的指定属性进行排序**
            1. 进行遍历输出时，会从小到大输出
            2. 两种排序方式：**自然排序** 和 **定制排序**
            3. 如果需要对自定义对象进行排序，需要将该对象的类实现 **comparable** 接口并重写**compareTo()** 方法规定对该类对象如何进行排序，或者**comparator接口并重写compare(obj1,obj2)方法**
            4. 添加元素时根据compareTo方法进行比较，有时会需要多级比较，例如对象的name相同而age不相同，则需要在比较name之后如果相同则继续比较age。其他情况类似。
- Set接口中没有额外增加方法，所以和collection中的方法相同

## 面试题

1. Collection中若存储自定义对象，需要重写什么方法？ **equals()方法**
    1. List：**equals方法**
    2. set
        1. HashSet，LinkedList ： **equals方法，HashCode方法**
        2. TreeSet：1. Comparable：**compareTo(obj)**  2. Comparator：**compare(obj1,obj2)**
2. ArrayList，LinkedList，Vector三者的相同点和不同点？ 
    1. 相同点：都实现了**List接口**，存储数据特点均为**有序，可重复**
    2. 不同点：
        1. 从底层实现来看，ArrayList底层是**数组**，LinkedList底层是**双向链表**，Vector底层也是**数组**；
        2. 从线程安全性来看，Vector是线程安全的，ArrayList和LinkedList是线程不安全的；
        3. 从操作类型来看，LinkedList适合于插入删除等操作，ArrayList适合于索引操作并且性能在三者中较高。
        4. 从使用时间和使用频率来看，Vector比较古老，剩余两者比较新；因此Vector使用次数也比较少，主要使用ArrayList和LinkedList；
        5. 从底层扩容实现来看，ArrayList和Vector都是对数组进行扩容，ArrayLists是以**1.5倍**容量进行扩容，Vector是2倍容量扩容；LinkedList是增加节点
3. List接口常用方法有哪些？
    1. **增add(obj)** 
    2. **删remove(obj)\ remove(int index,obj)** 
    3. **改set(int index,obj)** 
    4. **查get(int index)** 
    5. **插add(int index,obj)** 
    6. **长度size** 
    7. **遍历iterator**
4. 如何使用三种遍历方法？**Iterator，增强for，普通for**





# Map

---

思维导图

![Map架构](D:\JAVA\Big_Data_Learning\Java\Advanced\Collection\Collection\Map.png)



map存储双列数据，存储‘Key-value’对的数据，主要有三个实现类，分别为

- **HashMap**
  - 作为Map的主要实现类，线程不安全，效率较高；可以存储null的key和value
  - 底层结构
    - JDK7之前，数组+链表
    - JDK8，数组+链表+红黑树
  - **LinkedHashMap 是其子类，保证在遍历map元素时可以按照添加顺序实现遍历**
    - 在HashMap底层结构上添加了一堆指针指向前一个和后一个键值对。方便频繁的遍历操作，执行效率高于HashMap
- **Hashtable**
  - 作为Map的古老类，线程安全，所以效率较低；不能存储null的key和value
  - Properties 是其子类，常用来处理配置文件，key和value都是String类型
- **SortedMap**
  - TreeMap是其子类，保证按照添加的键值对进行排序，实现排序遍历，此时考虑key的自然排序或定制排序；底层使用**红黑树**进行存储

**key和value的特点**

- Key不能重复，无序的，使用**Set**存储所有的key ——> key所在的类需要重写equals方法和HashCode方法
- value是可以重复的，无序的，使用**Collections**存储所有的value —> value所在类要重写equals方法
- Key-Value键值对在底层被称为**Entry,**所以map存储单位是Entry。
- Map中的Entry也是无序的、不可重复的，使用**Set**存储所有的Entry。

| key  | value |
| ---- | ----- |

## Map中的常用方法

### Map接口中的方法

Map的遍历

1. Map.EntrySet取出 Entry集合
2. Map.KeySet取出 键集合
3. Map.values 取出 values的collections集合

通过以上取出后可以分别使用**iterator**来遍历，但是Map本身是没有iterator的

- 添加 put(key,value)
- 删除 remove(key)
- 修改 Put(key,value)
- 查询 get(key)
- 长度 size()
- 遍历 keyset(),values(),entryset()

## HashMap

---

1. HashMap中的内部类：**Node**

   ```java
   /**
        * Basic hash bin node, used for most entries.  (See below for
        * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
        */
       static class Node<K,V> implements Map.Entry<K,V> {
           final int hash;  //hash值 代表地址值
           final K key;  // 键
           V value;
           Node<K,V> next;  //指向下一个node，类似指针
   
           Node(int hash, K key, V value, Node<K,V> next) {  //Node构造方法
               this.hash = hash;
               this.key = key;
               this.value = value;
               this.next = next;
           }
   ```

2. HashMap的构造器

   ```java
   /**
        * Constructs an empty {@code HashMap} with the specified initial
        * capacity and load factor.
        *
        * @param  initialCapacity the initial capacity
        * @param  loadFactor      the load factor
        * @throws IllegalArgumentException if the initial capacity is negative
        *         or the load factor is nonpositive
        */
       public HashMap(int initialCapacity, float loadFactor) {  //可以指明HashMap初始容量（>0）和加载因子(float)
           if (initialCapacity < 0)  //判断参数
               throw new IllegalArgumentException("Illegal initial capacity: " +
                                                  initialCapacity);
           if (initialCapacity > MAXIMUM_CAPACITY)  //初始容量太大
               initialCapacity = MAXIMUM_CAPACITY;  //按最大容量来创建
           if (loadFactor <= 0 || Float.isNaN(loadFactor))  //判断加载因子小于0或是NaN值则返回错误
               throw new IllegalArgumentException("Illegal load factor: " +
                                                  loadFactor);
           this.loadFactor = loadFactor;
           this.threshold = tableSizeFor(initialCapacity);  //returns a power of two size for the given target capacity就是把扩容临界值
       }
   /**
        * Returns a power of two size for the given target capacity.
        */
       static final int tableSizeFor(int cap) {
           int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);  //按照cap-1 右移运算 返回无符号整数i的最高非0位前面的0的个数
           return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
       }
   ```

3. HashMap中的内部类：**TreeNode**

   ```java
   /**
        * Entry for Tree bins. Extends LinkedHashMap.Entry (which in turn
        * extends Node) so can be used as extension of either regular or
        * linked node.
        */
       static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
           TreeNode<K,V> parent;  // red-black tree links
           TreeNode<K,V> left;
           TreeNode<K,V> right;
           TreeNode<K,V> prev;    // needed to unlink next upon deletion
           boolean red;
           TreeNode(int hash, K key, V val, Node<K,V> next) {
               super(hash, key, val, next);
           }
   ```

4. HashMap添加方法put()

   ```java
   /**
        * Implements Map.put and related methods.
        *
        * @param hash hash for key
        * @param key the key
        * @param value the value to put
        * @param onlyIfAbsent if true, don't change existing value
        * @param evict if false, the table is in creation mode.
        * @return previous value, or null if none
        */
       final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                      boolean evict) {
           Node<K,V>[] tab; Node<K,V> p; int n, i;
           if ((tab = table) == null || (n = tab.length) == 0)
               n = (tab = resize()).length;
           if ((p = tab[i = (n - 1) & hash]) == null)
               tab[i] = newNode(hash, key, value, null);
           else {
               Node<K,V> e; K k;
               if (p.hash == hash &&
                   ((k = p.key) == key || (key != null && key.equals(k))))
                   e = p;
               else if (p instanceof TreeNode)
                   e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
               else {
                   for (int binCount = 0; ; ++binCount) {
                       if ((e = p.next) == null) {
                           p.next = newNode(hash, key, value, null);
                           if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                               treeifyBin(tab, hash);
                           break;
                       }
                       if (e.hash == hash &&
                           ((k = e.key) == key || (key != null && key.equals(k))))
                           break;
                       p = e;
                   }
               }
               if (e != null) { // existing mapping for key
                   V oldValue = e.value;
                   if (!onlyIfAbsent || oldValue == null)
                       e.value = value;
                   afterNodeAccess(e);
                   return oldValue;
               }
           }
           ++modCount;
           if (++size > threshold)
               resize();
           afterNodeInsertion(evict);
           return null;
       }
   ```

**HashMap源码中重要的常量**

- **DEFAULT_INITIAL_CAPACITY**: 默认容量16

- MAXIMUM_CAPACITY: 最大容量$2^{30}$

- **DEFAULT_LOAD_FACTOR**: 默认加载因子，默认0.75

- **threshold**：扩容的临界值 = **容量 * 填充因子 = 16 * 0.75 ⇒ 12**

- TREEIFY_THRESHOLD: bucket中链表长度大于该默认值，转化为红黑树：8

- UNTREEIFY_THRESHOLD: Bucket中红黑树存储的Node小于该默认值，转化为链表

- MIN_TREEIFY_THERSHOLD: Bucket中的Node被树化时最小的hash表容量：64

  为什么扩容临界值是12而不是16？答：数组可能并不能填满，而存储的链表长度越来越长。一般情况下链表越长而导致查询效率会越低，因此我们希望链表较少，所以调节DEFAULT_HOLD_FACTOR，减少加载因子会减少扩容临界值

### LinkedHashMap

1. LinkedHashMap中的内部类：**Entry**

   ```java
   /**
        * HashMap.Node subclass for normal LinkedHashMap entries.
        */
       static class Entry<K,V> extends HashMap.Node<K,V> {  //Entry继承父类HashMap的内部类Node
           Entry<K,V> before, after;  //两个引用变量分别指向前一个Entry和后一个Entry
           Entry(int hash, K key, V value, Node<K,V> next) {   //构造方法
               super(hash, key, value, next);
           }
       }
   ```

### TreeMap

 TreeMap中添加key-value，要求key必须是同一个类创建的对象，因为要按照key来排序：自然排序、定制排序

### Properties

规定key和value都是string类型，主要用来处理配置文件

## Collections工具类

Collections工具类是操作Collection和Map的工具类

# 面试题

1. **HashMap的底层实现原理 October 13, 2022 8:22 PM 面试常考！！**

   `HashMap map = new HashMap();`

   在实例化之后，底层创建了长度是16的一维数组Entry[] table。

   `map.put(keyN,valueN)`

   **JDK7版本**

   在向map中存放数据时，首先调用keyN所在类的hashCode方法来计算keyN的哈希值，以此得到在Entry数组中的存放位置；

   如果此位置的数据为空，则直接添加成功；—>C1

   如果此位置的数据已经存储了数据（意味着存放了一个或多个数据（以链表形式存在）），比较当前KeyN和已存在的一个数据或多个数据的哈希值：

   如果KeyN的哈希值和已经存在的数据哈希值不相同，此时KeyN-valueN添加成功； —>C2

   如果KeyN的哈希值和已经存在的数据哈希值相同，则调用KeyN所在类的equals方法进行比较：

   如果equals方法返回false，说明KeyN和已存在数据不相同，因此添加成功； —>C3

   如果equals方法返回true，说明KeyN和已存在数据相同，使用valueN来替换相同key的value值；（更新了原有的数据）

   **JDK8版本改进**

   1. `new HashMap()` ：底层没有创建一个长度为16的数组
   2. 底层数组是Node[]，不是Entry[]
   3. 首次调用`put()` 方法时，才会创建长度为16的数组
   4. JDK7底层结构只有：数组+链表；JDK8中底层结构：数组+链表+红黑树。当数组的某一个索引位置上的元素以链表形式存在的数据个数**>8**且当前数组的长度超过**64**，此时此索引位置上的所有数据改为使用**红黑树存储。**
   5. 

2. HashMap和Hashtable的异同？

3. CurrentHashMap和Hashtable的异同

4. Collection和Collections的区别

   Collection是创建集合的接口，Collections是操作Collection和Map的工具类