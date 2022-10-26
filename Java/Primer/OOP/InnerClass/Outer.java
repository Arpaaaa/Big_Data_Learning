package Big_Data_Learning.Java.Primer.OOP.InnerClass;

public class Outer {
    int out = 3;
    //如果用private来修饰内部类，那么无法在外部创建内部类
    //获取内部类对象的方法
    //方法一：外部类编写方法，对外提供内部对象
    //方法二：直接创建
    public class Inner {
        static int age = 10;

        public void show(){
            System.out.println(Outer.this.out);
        }
    }

    public Inner getInstance(){
        return new Inner();
    }
}
