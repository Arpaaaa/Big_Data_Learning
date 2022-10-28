# 反射机制概述

#### 什么是反射？

反射机制允许通过Reflaction API来获得任何类的内部信息。通过创建一个Class类型的对象，这个对象包含了完整的类的结构信息，
因此我们可以通过此对象来看到类的结构和内部信息。

#### 反射机制的功能
1. 判断任意对象所属的类
2. 构造任意类的对象
3. 获取泛型信息
4. 判断任意一个类所具有的成员变量和方法
5. 处理注解
6. 生成动态代理
7. 相关的API
   1. `java.lang.Class` 代表一个类
   2. `java.lang.reflect.Method`  代表类的方法
   3. `java.lang.reflect.Field `  代表类的成员变量
   4. `java.lang.reflect.Constructor`  代表类的构造器

8. 反射机制是否与面向对象中的封装性矛盾？如何看待这两种技术？
   两者并不矛盾，从两者分开来说
   1. 封装性是为了类属性的私有化，防止从外部直接使用
   2. 反射机制主要是为了动态性，在程序运行过程中动态的产生用户需要的对象。反射多用与底层框架

9. 通过直接new的方式或反射的方式均可以调用公共结构，主要使用哪一种？
   一般情况下使用new即可
   反射的特征：动态性

   
## Class类并获取Class实例

#### 关于`java.lang.Class`类的理解

1. 类的加载过程
   
   程序经过javac.exe之后，生成一个或多个字节码文件(.class结尾)，再使用java.exe命令对某个字节码文件
进行解释运行，相当于把某个字节码文件加载到内存中，此过程被称为**类的加载**
加载到内存中的类被称为运行时类，就作为一个Class的一个实例，相当于创建了Class类的一个类对象。Class的实例
就是一个运行时类。

创建Class类实例
```java
public class ClassInstance{
   Class clazz = Person.class ;
   
    public Object getInstance(String className){
        Class clazz = Class.forName(className);
        return clazz;
        }
    }

```

#### `java.lang.Class`方法

`static Class forName(String name)` 返回一个名为name的Class对象
`Constructor getConstructor(Class...parameterTypes)` 返回类的构造器

####  `java.reflect.Constructor`方法
`Object newInstance(Object...params)` 返回类的一个实例

2. 加载到内存中的运行时类会缓存一定的时间，在此时间之内可以通过不同的方式来获取此运行时类

3. 哪些类型可以有Class对象
   1. class
   2. interface
   3. Array
   4. enum
   5. annotation
   6. primitive type
   7. void 
4. 如何判断两个Class实例相同？

   如果两个实例的元素类型和维度相同，那么就可以认定两个实例相同。可以通过‘==’来判断实例是否相同

## 创建运行时类的对象

```java
public class Instance {
   public void test() throws Exception {
      Class<Person> clazz = Person.class;
      //newInstance:创建对应运行时类的对象
      Person p1 = clazz.getDeclaredConstructor().newInstance();
   }
}
```

* 用此方式创建运行时类对象的要求：
  * 运行时类必须提供空参构造器
  * 空参的构造器的访问权限满足情况，通常为public

* 在JavaBean中要求提供一个空参构造器
  * 便于通过反射，创建运行时类的对象
  * 便于子类继承此运行时类时，默认调用super(),保证父类有此构造器

## 获取运行时类的完整结构和指定结构

### 完整结构

完整结构包括 类中全部的属性和方法以及父类的属性和方法
主要包括两种方法`get**()`和`getDeclared**()`

```java
class get{
    public void get(){
        //属性
       Field declaredField = personClass.getDeclaredField("name");
       Field field = personClass.getField("name");
       //方法
       Method[] declaredMethods = personClass.getDeclaredMethods();
       Method method = personClass.getMethod("drink");
       //修饰符
       int modifiers = personClass.getModifiers();
       //构造器
       Constructor<Person> constructor = personClass.getConstructor();
       Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor();
       //注解
       Annotation annotation = personClass.getAnnotation();
       Annotation[] declaredAnnotations = personClass.getDeclaredAnnotations();
       //接口
       Class<?>[] interfaces = personClass.getInterfaces();
       Annotation[] declaredAnnotationsByType = personClass.getDeclaredAnnotationsByType();

    }
}
```

### 指定结构


## 反射的应用：动态代理
