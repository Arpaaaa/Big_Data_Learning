package Big_Data_Learning.Java.Primer.OOP.InnerClass;
/*内部类有哪些分类
* 成员内部类
* 静态内部类
* 局部内部类
* 匿名内部类
* */

public class Car {
    public String carName;
    public int carAge;
    public String carColor;

    //外部类无法访问内部类的成员
    public void show(){
        System.out.println(this.carName);
    }

    class Engine{
        String engineName;
        int engineAge;

        //内部类可以访问外部类的成员变量
        public void show(){
            System.out.println(engineName);
            System.out.println(engineAge);
        }
    }
}
