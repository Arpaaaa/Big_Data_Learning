package Big_Data_Learning.Java.Primer.OOP.InnerClass.anonymousClass;

public class Test {

    public static void main(String[] args) {
        /*匿名内部类
        * 格式： new 类名或接口名(){  重写方法; }
        * 当实现类只要使用一次时，就可以使用匿名内部类
        * */

        //{}内中指的就是“没有名字”的内部类
        //new创建这个“没有名字”的内部类对象
        //Swim()是“没有名字”内部类实现了Swim接口
        //下面的代码实质是创建了一个没有名字的内部类对象
        new Swim(){

            @Override
            public void swim() {
                System.out.println("Override swim method");
            }
        };
        //new Swim(){}.swim();  因为创建的是Swim对象所以可以调用方法swim()

    }

}
