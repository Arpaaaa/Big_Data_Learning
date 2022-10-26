package Big_Data_Learning.Java.Primer.OOP.polymorphism.demo1;

public class student extends Person{
    @Override
    public void show(){
        System.out.println("Student's massge is " + getName() + "," + getAge());
    }
}
