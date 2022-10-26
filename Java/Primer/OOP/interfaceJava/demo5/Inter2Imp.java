package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo5;

public class Inter2Imp extends InterAdapter{
    //实现类可以使用Inter接口中的任意方法而不用实现其他的接口中的方法
    //这就是适配器的作用，在中间空实现了所有接口中的方法
    //继承适配器的所有类均可以任意使用接口中的方法
    //假设实现类只需要使用method3方法
    @Override
    public void method3() {
        super.method3();
        System.out.println("this is method3");
    }
}
