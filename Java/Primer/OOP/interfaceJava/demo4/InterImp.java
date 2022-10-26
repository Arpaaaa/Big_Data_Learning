package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo4;

public class InterImp implements Inter{
    @Override
    public void method() {
        System.out.println("this is a method");
    }
    //如果要重写接口中的默认方法，需要去掉default关键字
    @Override
    public void show() {
        Inter.super.show();
    }



}
