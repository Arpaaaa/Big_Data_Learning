# 数据结构与算法

---

- [x] 数组
- [ ] 链表
- [ ] 递归

- [ ] 排序算法
- [ ] 时间复杂度分析
- [ ] 查找算法
- [ ] 哈希表
- [ ] 树结构  （二叉树、顺序存储、线索化，堆排序，赫夫曼树）
- [ ] 多路查找树（二叉树与B树，2-3树）
- [ ] 图
- [ ] 常用十大算法（分治算法、KMP、贪心、普利姆、克鲁斯卡尔算法、迪杰斯特拉、弗洛伊德算法



# 线性结构与非线性结构

---

1. 线性结构特点：数据元素之间存在一对一的线性关系
2. 线性结构有两种不同的存储结构，顺序存储结构与链式存储结构；顺序存储的结构称为顺序表，链式存储结构称为链表
3. 线性结构通常有：数组、队列、链表和栈
4. 非线性结构包括：二维数组、多维数组、广义表、**树结构和图结构**



# 稀疏数组

---

稀疏数组 sparse array

## 基本介绍

当一个数组中大部分元素为0或者为同一个值的数组时，可以用稀疏数组来保存

## 处理方法

1. 记录数组一共有几行几列，有多少不同的值
2. 把具有不同值的元素的行列及值记录再一个小规模的数组中，从而缩小程序的规模



## 应用实例

使用稀疏数组来保存二维数组（棋盘、地图等）

例如11行11列的二维数组中有两个值，并且坐标为(1,2)和(3,4)，那么该稀疏数组如下：

|      | row  | col  | value |
| ---- | ---- | ---- | ----- |
| 0    | 11   | 11   | 2     |
| 1    | 1    | 2    | 32    |
| 2    | 3    | 4    | 22    |



### 二维数组转稀疏数组的思路

1. 遍历原始的二维数组得到有效数据的个数sum
2. 根据sum就可以创建稀疏数组sparseArr `int[sum+1][3]`
3. 将二维数组的有效数据存入到稀疏数组

### 稀疏数组转二维数组的思路

1. 先读取稀疏数组的第一行，根据第一行数据创建原始的二维数组
2. 在读取稀疏数组后几行的数据，并赋给原始的二维数组即可



# 队列

---

**队列是一个有序列表，可以用数组或链表来实现**

遵循先入先出的原则，即：先存入队列的数据，要先取出。后存入的数据后取出



## 队列的代码实现

---

### 循环队列的实现

思路：

1. front指向队列的第一个元素，arr[front]是队列的第一个元素
2. rear指向最后一个元素的后一个位置，留出一个空位作为约定
3. 当队列满时，条件是`(rear+1)%maxSize=front`
4. 当队列为空时，条件是`rear=front`。
5. 当前队列中有效的数据个数为`(rear+maxSize-front)%maxSize`

注：在以上思路下，往往会多空出一个位置，会造成内存浪费，所以可以通过一下方法进行改进

1. 添加size变量来记录队列的长度，当`size=maxsize`时，队列为满
2. 添加tag=0/1变量，0为出栈1为进栈。最后如果是0则说明队列为空，1为队列为满

### 代码实现

```java
import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args){
        //create queue
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show): show queue");
            System.out.println("e(exit): exit queue");
            System.out.println("a(add): add data to queue");
            System.out.println("g(get): get data from queue");
            System.out.println("h(head): get the head data of queue");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("Please enter a number");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("the value is %d\n",res);
                    }catch (Exception e){
                        //TODO handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("the value is %d\n",res);
                    }catch (Exception e){
                        //TODO handle exception
                        System.out.println(e.getMessage());
                    }
                case 'e':
                    scanner.close();    //退出输入
                    loop = false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("The program is closed");
    }

}

class CircleArrayQueue{
    public int maxSize;
    int front;  //队头
    int rear;   //队尾
    int[] arr;  //该数组用来存放数据

    //创建队列的构造器
    public CircleArrayQueue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        //this.front = 0;    //指向队列头部，分析出front指向队列头的前一个位置
        //this.rear = 0;     //指向队列尾部，直接指向队列的尾部，即最后一个元素
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到队列中
    public void addQueue(int n){
        //判断队列
        if(isFull()){
            System.out.println("The Queue is full");
        }
        //因为rear指代最后一个元素的后一位所以我们可以直接插入元素
        arr[rear]=n;
        //重新调节rear的值
        rear = (rear+1)%maxSize;
    }
    //出队列，获取队列数据
    public int getQueue(){
        //判断队列
        if (isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("The Queue is empty");
        }
        //front已经指向队列的第一个元素,所以可以直接返回arr中front位置的数据，并将front往后移动，再向后移动是需要考虑取模
        int temp = arr[front];
        front = (front+1)%maxSize;
        return temp;
    }
    //删除队列中的数据，默认只能删除第一个元素，front向后移一位
    /*
    public boolean delQueue(){
        //判空
        if (isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("The Queue is empty");
        }
        //删除第一个元素

    }
    */
    //展示队列中的数据
    public void showQueue(){
        //判空
        if (isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("The Queue is empty");
        }
        //展示队列应该从front开始遍历，直到
        for (int i = front; i < front + getSize(); i++) {
            //TODO:重点理解一下这里 i%maxSize的意义
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        //判空
        if (isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("The Queue is empty");
        }
        return arr[front+1];

    }
    //求出当前队列的有效数据个数
    public int getSize(){
        return (rear+maxSize-front)%maxSize;
    }

}
```



# 链表

---

**Linked list**

1. 链表是以节点的形式进行存储
2. 每个节点必须包括data域和next域（指向下一个节点）
3. 链表的存储不一定是连续存放的
4. 链表分带头节点和不带头节点的链表

逻辑结构

`head->a1->a2->a3->···->an`



## 单链表的创建

1. 先创建一个head头结点，作用是表示单链表的头
2. 我们每添加一个节点就直接加入到链表的最后



### 单链表中节点信息的修改





### 单链表中节点的删除

1. 先找到需要删除的节点的前一个节点temp
2. 让`temp.next=temp.next.next`
3. 被删除的节点就不会有其他引用指向，将会被垃圾回收机制(gc)回收

```java
public class SingleLinkedListDemo {
    public static void main(String[] args){
        //测试单链表
        //创建节点

        HeroNode hero1 = new HeroNode(1,"Songjiang","Dog");
        HeroNode hero2 = new HeroNode(2,"Lujunyi","cat");
        HeroNode hero3 = new HeroNode(3,"Wuyong","tiger");
        HeroNode hero4 = new HeroNode(4,"LingChong","Cow");

        //创建单链表
        SingleLinkedList list = new SingleLinkedList();

        //将节点加入单链表
        /*第一种添加方式
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);
        */
//        第二种添加方式
        list.addByOrder(hero1);
        list.addByOrder(hero2);
        list.addByOrder(hero4);
        list.addByOrder(hero3);
        //显示单链表中的数据
        list.list();

        //测试修改节点的数据
        HeroNode newHeroNode = new HeroNode(1,"xiaolu","fish");
        list.update(newHeroNode);

        System.out.println("The updated linked list: ");
        list.list();

        //测试删除节点
        System.out.println("The list after deleted some node: ");
        list.del(1);
        list.del(4);
        list.list();
    }

}

//首先定义一个HeroNode，每个HeroNode对象就是一个节点，和C语言中的结构体类似
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;   //这里是创建一个HeroNode对象叫next，指代下一个节点

    //constructor
    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方法，我们重新对toString函数重写
    @Override
    public String toString(){
        return "HeroNode [no = " + no + ",name = " + name + ", nickname = " + nickName + "]";
    }
}

//定义一个单链表，用来管理英雄
class SingleLinkedList {
    //先创建一个头结点，并且不能去移动头节点
    private final HeroNode head = new HeroNode(0,"","");

    //添加英雄节点到链表的最后
    //添加思路，在不考虑添加元素编号的顺序时，找到链表的最后节点并将最后节点的next指向要插入的元素
    public void add(HeroNode heroNode){
        //因为head不能动，所以我们使用head节点的copy
        HeroNode temp = head;
        while (true){
            if (temp.next==null){
                break;
            }
            //如果没有找到就将temp向后移动
            temp = temp.next;
        }
        //当退出该while循环时，temp就是指向最后一个节点
        //现在就添加heroNode
        temp.next = heroNode;
    }

    //第二种添加节点的方法
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;   //flag说明编号是否已经在单链表中存在
        while (true){
            if (temp.next==null) {
                //此时说明temp已经遍历到单链表的底部
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            } else if (temp.next.no == heroNode.no) {
                //此时说明编号已经存在，退出程序
                flag = true;
                break;
            }
            //将temp向后移动以为
            temp = temp.next;
        }
        //判断flag的值
        if (flag){
            System.out.printf("The insert node %d already exist, you can't insert more",heroNode.no);
        }else {
            //插入到链表中,并插入到temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //修改节点的信息，根据编号no来修改，no不能改变
    public void update(HeroNode newHeroNode){
        //判空
        if(head.next==null){
            System.out.println("The linked list is empty");
        }
        //找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if(temp.no==newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("The Node No. " + newHeroNode.no + " need to be changed can't be found");
        }
    }
//  实现删除节点方法
    public void del(int no){
        //判空
        if(head.next==null){
            System.out.println("The linked list is empty");
        }
        HeroNode temp = head;
        boolean flag = false;   //标志是否找到删除节点的前一个节点
        while (true){
            if (temp.next==null){
                break;
            }
            if(temp.next.no==no){
                //找到删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
        }else {
            System.out.println("The node can't be found");
        }
    }
    //显示链表
    public void list(){
        //判空
        if(head.next==null){
            System.out.println("The linked list is empty");
        }
        //使用temp进行遍历
        HeroNode temp = head.next;  //temp设定为单链表第一个节点
        while (true){
            if (temp==null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp向后移动
            temp = temp.next;
        }
    }
}
```



## 单链表的面试题

1. 求单链表中节点的个数

解题思路：遍历法

2. 寻找单链表中的倒数第k个节

解题思路：写一个方法，参数为head和index；index是表示倒数第index个数；先把链表从头到尾遍历得到链表的长度getLength()；得到链表的长度后，从链表第一个遍历并返回第size-index个

3. 单链表的反转

解题思路：

* 先定义一个节点`reverseHead = new HeroHead();`
* 遍历原来的链表，并放在新链表的最前端
* 原来的链表的`head.next= reverseHead.next;`

4. 从尾到头打印链表

解题思路：

* 利用栈数据结构，将链表的数据节点压入栈中
* 利用栈的先进后出的特点实现逆序打印

5. 合并两个有序的单链表，合并之后的链表依然有序



## 双链表的创建

---

分析双向链表的遍历、添加、修改、删除的操作思路

1. 遍历

   遍历方式和单链表相同，只是可以向前查找

2. 添加（插入到最后）

   先找到双向链表的最后节点 `temp.next = HeroNode`

   将插入链表指向最后节点`HeroNode.pre = temp`

3. 修改的操作思路和原来单向列表相同

4. 删除

   因为是双向链表，因此可以自我删除，无需找到前一个节点

   例如删除temp

   `temp.pre.next = temp.next`

   `temp.next.pre = temp.pre`

   



































