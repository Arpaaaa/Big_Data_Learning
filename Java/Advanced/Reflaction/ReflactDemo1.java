package Big_Data_Learning.Java.Advanced.Reflaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflactDemo1 {

    public static void main(String[] args) {
        ReflactDemo1 reflactDemo1 = new ReflactDemo1();

        try {
            reflactDemo1.getClassInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //一些基本方法
    public void test1(){
        //创建Person类对象
        Person jack = new Person("Jack", 20);

        //调用内部属性和方法
        System.out.println(jack.toString());


    }

    //反射机制获取Person类的构造器并创建对象
    public void test2() throws Exception {
        //创建Class类对象
        Class<Person> clazz = Person.class;
        //获取Person类的构造器
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        //创建Person类对象
        Object jack = constructor.newInstance("Jack", 20);
        System.out.println(jack);

        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(jack,24);   //设置属性值
        System.out.println(jack);

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(jack);

        //通过反射调用Person类的私有结构
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Mary");
        System.out.println(p1);

        //调用私有方法
        Method method = clazz.getDeclaredMethod("show",String.class);
        method.setAccessible(true);
        method.invoke(p1,"show");    //调用Person类的方法

    }

    /**
     * 获取Class类实例的四种方式
     */
    public void getClassInstance() throws ClassNotFoundException {
        //方式一:调用运行时类的属性
        Class<Person> clazz1 = Person.class;

        //方式二:通过运行时类的对象
        Person p1 = new Person();
        Class<? extends Person> p1Class = p1.getClass();

        //方式三:调用Class的静态方法
        Class<?> class3 = Class.forName("Big_Data_Learning.Java.Advanced.Reflaction.Person");

        //方式四:调用类的加载器ClassLoader
        ClassLoader classLoader = ReflactDemo1.class.getClassLoader();
        Class<?> class4 = classLoader.loadClass("Big_Data_Learning.Java.Advanced.Reflaction.Person");



    }

}
