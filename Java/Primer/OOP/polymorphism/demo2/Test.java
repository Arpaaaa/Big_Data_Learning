package Big_Data_Learning.Java.Primer.OOP.polymorphism.demo2;

public class Test {
    public static void main(String[] args) {
        //调用成员变量：编译看左边，运行看左边
        //调用成员方法，编译看左边，运行看右边
        Animal animal = new Dog();
        //animal是Animal类，调用Animal父类的成员变量
        System.out.println(animal.name);    //输出animal，父类的成员变量

        //当子类把父类的方法重写时，在虚方法表中父类的方法被覆盖了，所以调用方法时调用了子类的方法
        animal.show();  //子类的成员方法

    }
}

class Animal{
    String name = "animal";
    public void show(){
        System.out.println("Animal");
    }
}

class Dog extends Animal{
    String name = "dog";
    {
        System.out.println("start");
    }
    @Override
    public void show(){
        System.out.println("DOG");
    }
}
