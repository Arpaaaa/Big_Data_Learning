package Big_Data_Learning.Java.Primer.OOP.polymorphism.demo1;

public class administrator extends Person{
    @Override
    public void show(){
        System.out.println("Administrator massage is " + getName() + "," + getAge());
    }
}
