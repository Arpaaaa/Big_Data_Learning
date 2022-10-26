package Big_Data_Learning.Java.Primer.OOP.InnerClass;

public class test1 {
    public static void main(String[] args) {
        /*Car car = new Car();
        car.carName = "Bingli";
        car.carAge = 2;
        */

        //测试Outer
        //创建内部类对象的方法 Outer.Inner oi = new Outer().new Inner();
        Outer.Inner oi = new Outer().new Inner();
        Outer o = new Outer();
        //通过类方法来获取内部类对象
        System.out.println(o.getInstance());
        //在内部类中获取外部类的成员变量
        oi.show();

    }
}
