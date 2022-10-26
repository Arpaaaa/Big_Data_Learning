package Big_Data_Learning.Java.Primer.OOP.abstractjava.demo1;

public abstract class Animal {
    //抽象类不能实例化
    //抽象类不一定有抽象方法，有抽象方法的类一定是抽象类
    //可以有构造方法
    //子类要么重写所有抽象方法，要么标志为抽象类

    public abstract void work();

    public Animal() {
        //构造方法在子类中创建对象使用
    }
}
