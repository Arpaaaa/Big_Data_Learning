package Big_Data_Learning.Java.Primer.OOP.abstractjava.demo1;

public class Sheep extends Animal{
    //sheep 继承抽象类需要实现父类中的方法，不然sheep也是抽象方法
    @Override
    public void work() {
        System.out.println("eat grass");
    }

}
