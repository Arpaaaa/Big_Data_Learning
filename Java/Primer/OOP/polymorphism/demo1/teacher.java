package Big_Data_Learning.Java.Primer.OOP.polymorphism.demo1;

public class teacher extends Person{
    @Override
    public void show(){
        System.out.println("Teacher's massage is " + getName() + "," +getAge());
    }
}
