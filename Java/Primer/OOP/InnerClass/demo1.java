package Big_Data_Learning.Java.Primer.OOP.InnerClass;

public class demo1 {
    public void show(){
        final int a = 10;

        //局部内部类
        class Inner{
            String name;
            int age;
            public void method1(){
                System.out.println("Method 1 ");
            }
        }
        //在方法中创建对象获取局部内部类的成员变量和成员方法
        Inner i = new Inner();
        System.out.println(i.age);
        i.method1();
    }
}
