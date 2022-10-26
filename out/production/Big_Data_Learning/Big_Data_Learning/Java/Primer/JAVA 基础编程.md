# JAVA 基础编程

[TOC]

第一个JAVA程序

```java
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("HelloWorld");
    }
}
```

注：`args`是指字符串数组，`String[]`指string类

## 基本语法

### 注意点

1. JAVA区分大小写
2. 对于所有类名称，首字母必须大写，多个单词则每个单词首字母大写
3. 对于所有方法名称，需要用小写字母开头，多个单词则每个单词首字母大写
4. 源文件名必须与类名称相同
5. 主方法入口：所有程序都由`public static void main(String[] args)` 开始执行

> JAVA语言中，print() 输出不会换行，而println()输出会换行

### 标识符与修饰符

Java 所有的组成部分都需要名字。类名、变量名以及方法名都被称为标识符。

关于 Java 标识符，有以下几点需要注意：

- 所有的标识符都应该以字母（A-Z 或者 a-z）,美元符（$）、或者下划线（_）开始
- 首字符之后可以是字母（A-Z 或者 a-z）,美元符（$）、下划线（_）或数字的任何字符组合
- 关键字不能用作标识符
- 标识符是大小写敏感的
- 合法标识符举例：age、$salary、_value、__1_value
- 非法标识符举例：123abc、-salary

像其他语言一样，Java可以使用修饰符来修饰类中方法和属性。主要有两类修饰符：

- 访问控制修饰符 : default, public , protected, private
- 非访问控制修饰符 : final, abstract, static, synchronized

### JAVA关键字

* 注意在程序中所有关键字**均需要小写**

| 类别                 | 关键字                         | 说明                 |
| :------------------- | :----------------------------- | :------------------- |
| 访问控制             | private                        | 私有的               |
|                      | protected                      | 受保护的             |
|                      | public                         | 公共的               |
|                      | default                        | 默认                 |
| 类、方法和变量修饰符 | abstract                       | 声明抽象             |
| |class                | 类，用于创建一个类                                          |
| |extends              | 扩充,继承                                           |
| |final                | 最终值,不可改变的                                    |
| |implements           | 实现（接口）                                         |
| |interface            | 接口                                                 |
| |native               | 本地，原生方法（非 Java 实现）                       |
| |new                  | 新,创建                                              |
| |static               | 静态                                                 |
| |strictfp             | 严格,精准                                            |
| |synchronized         | 线程,同步                                            |
| |transient            | 短暂                                                 |
| |volatile             | 易失                                                 |
| 程序控制语句         | break                          | 跳出循环             |
| |case                 | 定义一个值以供 switch 选择                           |
| |continue             | 继续                                                 |
| |default              | 默认                                                 |
| |do                   | 运行                                                 |
| |else                 | 否则                                                 |
| |for                  | 循环                                                 |
| |if                   | 如果                                                 |
| |instanceof           | 实例                                                 |
| |return               | 返回                                                 |
| |switch               | 根据值选择执行                                       |
| |while                | 循环                                                 |
| 错误处理             | assert                         | 断言表达式是否为真   |
| |catch                | 捕捉异常                                             |
| |finally              | 有没有异常都执行                                     |
| |throw                | 抛出一个异常对象                                     |
| |throws               | 声明一个异常可能被抛出                               |
| |try                  | 捕获异常                                             |
| 包相关               | import                         | 引入                 |
| |package              | 包                                                   |
| 基本类型             | boolean                        | 布尔型               |
| |byte                 | 字节型                                               |
| |char                 | 字符型                                               |
| |double               | 双精度浮点                                           |
| |float                | 单精度浮点                                           |
| |int                  | 整型                                                 |
| |long                 | 长整型                                               |
| |short                | 短整型                                               |
| 变量引用             | super                          | 父类,超类            |
| |this                 | 本类                                                 |
| |void                 | 无返回值                                             |
| 保留关键字           | goto                           | 是关键字，但不能使用 |
| |const                | 是关键字，但不能使用                                 |

### 继承

在 Java 中，一个类可以由其他类派生。如果你要创建一个类，而且已经存在一个类具有你所需要的属性或方法，那么你可以将新创建的类继承该类。

利用继承的方法，可以重用已存在类的方法和属性，而不用重写这些代码。被继承的类称为超类（super class），派生类称为子类（sub class）。



### 创建对象

对象是根据类创建的。在Java中，使用关键字 new 来创建一个新的对象。创建对象需要以下三步：

- **声明**：声明一个对象，包括对象名称和对象类型。
- **实例化**：使用关键字 new 来创建一个对象。
- **初始化**：使用 new 创建对象时，会调用构造方法初始化对象。

### 访问实例变量和方法

```java
//实例化对象
Object referenceVariable = new Constructor();
//访问类中的变量
referenceVariable.variableName;
//访问类中的方法
referenceVariable.methodName();
```

### 源文件声明规则

在本节的最后部分，我们将学习源文件的声明规则。当在一个源文件中定义多个类，并且还有import语句和package语句时，要特别注意这些规则。

- 一个源文件中只能有一个 public 类
- 一个源文件可以有多个非 public 类
- 源文件的名称应该和 public 类的类名保持一致。例如：源文件中 public 类的类名是 Employee，那么源文件应该命名为Employee.java。
- 如果一个类定义在某个包中，那么 package 语句应该在源文件的首行。
- 如果源文件包含 import 语句，那么应该放在 package 语句和类定义之间。如果没有 package 语句，那么 import 语句应该在源文件中最前面。
- import 语句和 package 语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。

### 计算机的存储方式

#### 如何理解二进制

相对于十进制，十进制的逻辑在锋十进一，那么二进制下是逢二进一

### 键盘录入

使用`Scanner`类来实现键盘录入

```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
int i = sc.nextInt();	//z
```



## 基本数据类型

JAVA 两大数据类型

1. 内置数据类型
2. 引用数据类型

### 内置数据类型

**byte：**

- byte 数据类型是8位、有符号的，以二进制补码表示的整数；
- 最小值是 **-128（-2^7）**；
- 最大值是 **127（2^7-1）**；
- 默认值是 **0**；
- byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；

**short：**

- short 数据类型是 16 位、有符号的以二进制补码表示的整数
- 最小值是 **-32768（-2^15）**；
- 最大值是 **32767（2^15 - 1）**；
- Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
- 默认值是 **0**；

**int：**

- int 数据类型是32位、有符号的以二进制补码表示的整数；
- 最小值是 **-2,147,483,648（-2^31）**；
- 最大值是 **2,147,483,647（2^31 - 1）**；
- 一般地整型变量默认为 int 类型；
- 默认值是 **0** ；

**long：**

- long 数据类型是 64 位、有符号的以二进制补码表示的整数；
- 最小值是 **-9,223,372,036,854,775,808（-2^63）**；
- 最大值是 **9,223,372,036,854,775,807（2^63 -1）**；
- 这种类型主要使用在需要比较大整数的系统上；
- 默认值是 **0L**；需要在后面加L标识

**float：**

- float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
- float 在储存大型浮点数组的时候可节省内存空间；
- 默认值是 **0.0f**；需要在后面加f标识
- 浮点数不能用来表示精确的值，如货币；
- 例子：float f1 = 234.5f。

**double：**

- double 数据类型是双精度、64 位、符合 IEEE 754 标准的浮点数；
- 浮点数的默认类型为 double 类型；
- double类型同样不能表示精确的值，如货币；
- 默认值是 **0.0d**；

**boolean：**

- boolean数据类型表示一位的信息；
- 只有两个取值：true 和 false；
- 这种类型只作为一种标志来记录 true/false 情况；
- 默认值是 **false**；
- 例子：boolean one = true。

**char：**

- char 类型是一个单一的 16 位 Unicode 字符；
- 最小值是 **\u0000**（十进制等效值为 0）；
- 最大值是 **\uffff**（即为 65535）；
- char 数据类型可以储存任何字符；
- 例子：char letter = 'A';。



**类型默认值**

| **数据类型**           | **默认值** |
| :--------------------- | :--------- |
| byte                   | 0          |
| short                  | 0          |
| int                    | 0          |
| long                   | 0L         |
| float                  | 0.0f       |
| double                 | 0.0d       |
| char                   | 'u0000'    |
| String (or any object) | null       |
| boolean                | false      |



### 引用类型

- 在Java中，引用类型的变量非常类似于C/C++的指针。引用类型指向一个对象，指向对象的变量是引用变量。这些变量在声明时被指定为一个特定的类型，比如 Employee、Puppy 等。变量一旦声明后，类型就不能被改变了。
- 对象、数组都是引用数据类型。
- 所有引用类型的默认值都是null。
- 一个引用变量可以用来引用任何与之兼容的类型。



## 变量类型

定义变量时的注意事项

* 只能存一个值
* 不允许重复定义
* 一条语句可以定义多个变量
* 变量在使用之前一定要赋值

java中的变量类型有三种：

* 类变量：独立于方法之外的变量，用static修饰
* 实例变量：独立于方法之外，但是不用static修饰
* 局部变量：类的方法中的变量

所有变量在使用前都需要先声明，声明格式如下：

```java
type identifier [=value][,identifier[=value]...]; 
/*
type 是变量类型
identifier 是变量名称
*/
int a ,int b ,float c,char ch;
String s = "Arpat"
```

举个例子

```java
public class Variable{
    static int allClicks=0;		//类变量
    String str = "Hello";	//实例变量
    public static void main(String[] args){
        int i = 1;	//局部变量
    }
}
```



### 类变量

* 类变量也称为静态变量，使用static来修饰，需要在方法之外
* 无论类有多少个对象，类只有类变量的一份拷贝
* 静态变量除了被声明为常量外很少使用，静态变量指用`public,private,final,static`修饰的变量，并且初始化后不可改变
* 储存在静态存储区
* 在第一次被访问时创建，在程序结束时销毁
* 为了类的使用者可见，所以大部分静态变量声明为public类型
* 静态变量可以用：`ClassName.VariableName`来访问
* 类变量使用`public,private,final`修饰时，类变量名称建议使用大写字母

### 实例变量

- 实例变量声明在一个类中，但在方法、构造方法和语句块之外；
- 当一个对象被实例化之后，每个实例变量的值就跟着确定；
- 实例变量在对象创建的时候创建，在对象被销毁的时候销毁；
- 实例变量的值应该至少被一个方法、构造方法或者语句块引用，使得外部能够通过这些方式获取实例变量信息；
- 实例变量可以声明在使用前或者使用后；
- 访问修饰符可以修饰实例变量；
- 实例变量对于类中的方法、构造方法或者语句块是可见的。一般情况下应该把实例变量设为私有。通过使用访问修饰符可以使实例变量对子类可见；
- 实例变量具有默认值。数值型变量的默认值是0，布尔型变量的默认值是false，引用类型变量的默认值是null。变量的值可以在声明时指定，也可以在构造方法中指定；
- 实例变量可以直接通过变量名访问。但在静态方法以及其他类中，就应该使用完全限定名：ObjectReference.VariableName。



## 修饰符

java中有两类修饰符：**访问修饰符和非访问修饰符**

### 访问控制修饰符

* default：在同一包中可见，不适用任何修饰符，使用对象：类、接口、对象和方法
* private：在同一类内可见。使用对象：变量、方法。 **注意：不能修饰类（外部类**
* **public** : 对所有类可见。使用对象：类、接口、变量、方法
* **protected** : 对同一包内的类和所有子类可见。使用对象：变量、方法。 **注意：不能修饰类（外部类）**



| 修饰符      | 当前类 | 同一包内 | 子孙类(同一包) | 子孙类(不同包)                                               | 其他包 |
| :---------- | :----- | :------- | :------------- | :----------------------------------------------------------- | :----- |
| `public`    | Y      | Y        | Y              | Y                                                            | Y      |
| `protected` | Y      | Y        | Y              | Y/N（[说明](https://www.runoob.com/java/java-modifier-types.html#protected-desc)） | N      |
| `default`   | Y      | Y        | Y              | N                                                            | N      |
| `private`   | Y      | N        | N              | N                                                            | N      |



### 非访问修饰符

* static修饰符，用来修饰类方法和类变量
* final修饰符，用来修饰类、方法和变量，final修饰的类不能被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，不可修改
* abstract，用来创建抽象类和抽象方法
* synchronized和volatile修饰符，主要用于线程的编程



## 运算符

### instanceof 运算符

该运算符用于操作对象实例，检查该对象是否是一个特定类型

```java
(Object reference variable) instanceof (class/interface type)
    
String name = "Jim";
boolean result = name instanceof String;
//判断name的类型是否是String，如果是则返回true
```

### 隐式转换和强制转换

1. 隐式转换：将取值范围小的数值转换为取值范围大的数值，程序自动完成
   1. byte,short,char三种类型数据运算时，都会直接先提升为int再进行运算
2. 强制转换：取值范围小转化为取值范围大的数值



取值范围：byte<short<int<long<float<doubl



## 循环结构

JAVA中主要有三种循环结构

* while 

  * ```java
    while(condition){
        statement
    }
    ```

  * 

* do…while

  * ```java
    do{
        statement
    }while(condition)
    ```

  * 

* for

  * ```java
    for(int i;i=0;i++){
        
    }
    //加强版,争对数组
    for(声明语句：表达式){
        
    }
    public class Test {
       public static void main(String[] args){
          int [] numbers = {10, 20, 30, 40, 50};
     
          for(int x : numbers ){
             System.out.print( x );
             System.out.print(",");
          }
          System.out.print("\n");
          String [] names ={"James", "Larry", "Tom", "Lacy"};
          for( String name : names ) {
             System.out.print( name );
             System.out.print(",");
          }
       }
    }
    ```

  * 

### 无限循环

```java
for(;;){
    System.out.println("");
}
while(true){
    System.out.println("");
}
do{				//不常用
    System.out.println("");
}while(true);
```

注：无限循环的下面就不用写其他代码，因为并不运行

### 跳转控制语句

关于跳转控制语句主要有三个：continue,break,

* continue：结束本次循环
* break：结束整个循环

```java
public class test{
    public static void main(String[] args){
        for(int i =0;i<5;i++){
            if(i==3){
                continue;  //跳过本次循环
                break;	//结束本次循环
            }
        }
    }
}
```



### 小练习

#### 一、逢7过

```java
public class MyRunnable {
    /*
    逢7过小游戏，打印输出1-100之间所有含有7或者7的倍数的数字
     */
    public static void main(String[] args){
        for(int i=1;i<=100;i++){
            //判断i是否含有7或是7的倍数
            if(i % 7==0 || i % 10 == 7||i/10==7){
                //i对10取余为7说明个位值含有7，对7取余为0说明是7的倍数
                System.out.println(i);
            }
        }
    }
}
```

#### 二、平方根

```java
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the value of x: ");
        int x = sc.nextInt();
        System.out.println(Math.sqrt(x));
    }
```

#### 三、判断质数

```java
/*
    输入任意数，判断是否为质数
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input x: ");
        int x = sc.nextInt();
        for(int i=2;i<=Math.sqrt(x);i++) {
            if (x % i == 0) {
                System.out.println(x + "is not zhishu");
                break;
            }
        }
    }
```



## String类

### String API

###### **String 的注意事项**

  1. 字符串的内容是不能改变的，对象在创建后就不能被更改
  2. String是属于Java.lang包中
  3. 当使用双引号直接赋值时，，系统会检查该字符串在串池中是否存在，如果存在就会复用，不存在才会创建新的string，极大的减少了内存的使用。

###### **创建String对象两种方式**

1. 直接复制
2. new一个新的string对象

###### Java中String类的比较常用方法

1. 等号“==”判断，因为string对象是引用类型，所以实际上是比较两个字符串对象的地址值。如果两个字符串分别是直接复制和new出来的，那么他们的地址值不同。
2. boolean equals(string) 完全一样才返回true
3. boolean equalsIgnoreCase(string) 忽略大小写进行比较

```java
class str{
  String substring(int beginindex,int endindex);

}
```


### Java StringBuffer 和 StringBuilder 类

* StringBuilder 可以视为一个容器，创建之后里面的内容是可变的。作用是提高字符串的操作效率

###### 构造器

`public StringBuilder()`
```java
class stringbuilder{
        StringBuilder.append
        StringBuilder.reverse()
        StringBuilder.()
        StringBuilder.toString()
}
```
###### 链式编程

当我们调用一个方法的时候，可以不用变量来接收其结果而可以继续调用其他方法

* 什么时候用StringBuilder? **字符串拼接和转置**

当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。

相当于生成了一个指定长度的字符串容器，并可以添加或删除容器内的字符串。

![img](https://www.runoob.com/wp-content/uploads/2013/12/java-string-20201208.png)

* **StringBuffer 和 StringBuilder 之间的区别是什么呢？**

  * 是否线程安全

    StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问），StringBuffer是线程安全的。
  只是StringBuffer 中的方法大都采用了 synchronized 关键字进行修饰，因此是线程安全的，而 StringBuilder 没有这个修饰，可以被认为是线程不安全的。

  * 应用场景

    由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
  然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。 append方法与直接使用+串联相比，减少常量池的浪费。

* String，StringBuffer 和 StringBuilder的区别

  * StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象，StringBuffer 与 StringBuilder 中的方法和功能完全是等价的。
调用StringBuffer 的 append 方法，来改变 StringBuffer 的长度，并且，相比较于 StringBuffer，String 一旦发生长度变化，是非常耗费内存的。
  * 三者在执行速度方面的比较：StringBuilder > StringBuffer > String
  * 应用场景
    * 如果要操作少量的数据用 = String 
    * 单线程操作字符串缓冲区 下操作大量数据 = StringBuilder 
    * 多线程操作字符串缓冲区 下操作大量数据 = StringBuffer

###### StringBuilder的底层原理

1. 在创建StringBuilder对象时，实质是创建了大小为16的字符数组。
2. 如果添加的内容小于16，则直接存
3. 如果添加内容大于16，则新的容量等于 原来容量*2+2
4. 还是不够，则以实际长度为准

###### 字符串拼接的底层原理

* 如果没有变量参与，都是字符串直接相加，可以复用串池中的字符串
* 如果有变量参与，会创建新的字符串，并会浪费内存



###### StringJoiner

拼接字符串的神器！！

```java
import java.util.StringJoiner;

//constructor
class sjr {
  public StringJoiner('间隔符号');
  public StringJoiner("","","");
  //method
  public StringJoiner add();
  public int length();
  public StringJoiner toString();
}
```





## 数组

```java
double [] mylist;
float [] mylist;
int [] mylist = {1,2,3,4,5};
```

使用new来创建数组格式

```java
datatype [] array = new datatype[arraysize];
```



### 多维数组的动态初始化

```java
type[][] typename = new type[typeLength1][typeLength2];
```



## 正则表达式

| 正则表达式       | 描述                                                         |
| :--------------- | :----------------------------------------------------------- |
| this is text     | 匹配字符串 "this is text"                                    |
| this\s+is\s+text | 注意字符串中的 **\s+**。匹配单词 "this" 后面的 **\s+** 可以匹配多个空格，之后匹配 is 字符串，再之后 **\s+** 匹配多个空格然后再跟上 text 字符串。可以匹配这个实例：this is text |
| ^\d+(\.\d+)?     | ^ 定义了以什么开始\d+ 匹配一个或多个数字? 设置括号内的选项是可选的\. 匹配 "."可以匹配的实例："5", "1.5" 和 "2.21"。 |

`java.util.regex`包主要包含一下三类：

* `Pattern`类：pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。

* `Matcher`类：Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。

* `PatternSyntaxException：`

  PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误

### Matcher 类的方法

#### 索引方法

索引方法提供了有用的索引值，精确表明输入字符串中在哪能找到匹配：

| **序号** | **方法及说明**                                               |
| :------- | :----------------------------------------------------------- |
| 1        | **`public int start()`** 返回以前匹配的初始索引。            |
| 2        | **`public int start(int group)`**  返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引 |
| 3        | **``public int end()``** 返回最后匹配字符之后的偏移量。      |
| 4        | **`public int end(int group)`** 返回在以前的匹配操作期间，由给定组所捕获子序列的最后字符之后的偏移量。 |

#### 查找方法

查找方法用来检查输入字符串并返回一个布尔值，表示是否找到该模式：

| **序号** | **方法及说明**                                               |
| :------- | :----------------------------------------------------------- |
| 1        | **public boolean lookingAt()**  尝试将从区域开头开始的输入序列与该模式匹配。 |
| 2        | **public boolean find()** 尝试查找与该模式匹配的输入序列的下一个子序列。 |
| 3        | **public boolean find(int start****）** 重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。 |
| 4        | **public boolean matches()** 尝试将整个区域与模式匹配。      |

#### 替换方法

替换方法是替换输入字符串里文本的方法：

| **序号** | **方法及说明**                                               |
| :------- | :----------------------------------------------------------- |
| 1        | **public Matcher appendReplacement(StringBuffer sb, String replacement)** 实现非终端添加和替换步骤。 |
| 2        | **public StringBuffer appendTail(StringBuffer sb)** 实现终端添加和替换步骤。 |
| 3        | **public String replaceAll(String replacement)**  替换模式与给定替换字符串相匹配的输入序列的每个子序列。 |
| 4        | **public String replaceFirst(String replacement)**  替换模式与给定替换字符串匹配的输入序列的第一个子序列。 |
| 5        | **public static String quoteReplacement(String s)** 返回指定字符串的字面替换字符串。这个方法返回一个字符串，就像传递给Matcher类的appendReplacement 方法一个字面字符串一样工作。 |

### PatternSyntaxException 类的方法

`PatternSyntaxException` 是一个非强制异常类，它指示一个正则表达式模式中的语法错误。

`PatternSyntaxException` 类提供了下面的方法来帮助我们查看发生了什么错误。

| **序号** | **方法及说明**                                               |
| :------- | :----------------------------------------------------------- |
| 1        | **public String getDescription()** 获取错误的描述。          |
| 2        | **public int getIndex()**  获取错误的索引。                  |
| 3        | **public String getPattern()** 获取错误的正则表达式模式。    |
| 4        | **public String getMessage()** 返回多行字符串，包含语法错误及其索引的描述、错误的正则表达式模式和模式中错误索引的可视化指示。 |

## 方法

`System.out.println()`

* println（）是方法
* System是系统类
* out是标准输出对象

### 形参和实参
* 形参是指方法中内部定义的参数,会随着方法的结束而被garbage collector 回收。
* 实参是指在方法之外定义的参数，只有到程序结束时才会被回收。 
### 如何定义一个方法

```java
/*
修饰符 返回值类型 方法名称（参数类型 参数名）{
    方法体；
    return 返回值
}
public static void main(String[] args){
}
 */
```

![img](https://www.runoob.com/wp-content/uploads/2013/12/D53C92B3-9643-4871-8A72-33D491299653.jpg)

### void关键字

* 一个void方法的调用一定是一个语句。 所以，它被在main方法第三行以语句形式调用。就像任何以分号结束的语句一样。
* void 修饰的方法是没有返回值的

### 方法的重载(方法具有相同的名称，但是参数不同)

上面使用的max方法仅仅适用于int型数据。但如果你想得到两个浮点类型数据的最大值呢？，解决方法是创建另一个有相同名字但参数不同的方法，如下面代码所示：

```java
public static double max(double num1, double num2) {
  if (num1 > num2)
    return num1;
  else
    return num2;
}
```

如果你调用max方法时传递的是int型参数，则 int型参数的max方法就会被调用；

如果传递的是double型参数，则double类型的max方法体会被调用，这叫做方法重载；

就是说一个类的两个方法拥有相同的名字，但是有不同的参数列表。

Java编译器根据方法签名判断哪个方法应该被调用。

方法重载可以让程序更清晰易读。执行密切相关任务的方法应该使用相同的名字。

重载的方法必须拥有不同的参数列表。你不能仅仅依据修饰符或者返回类型的不同来重载方法。

### 构造方法

简单的说就是传统意义上的定义函数，具体形式如下：
* 构造方法是编译器默认的，如果用户需要自行构造构造方法，那么必须有一个是没有参数的构造方法`className()`，再有其他带参数的构造方法`className(int)`.

```java
class MyClass{
    int x;
    MyClass(){	//构造函数
        x = 10;
    }
}
```



### finalize()方法

你可以使用 finalize() 来确保一个对象打开的文件被关闭了。在 finalize() 方法里，你必须指定在对象销毁时候要执行的操作。finalize() 一般格式是：

```java
protected void finalize(){
    
}
```

