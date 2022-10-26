package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo1;

public class Dog extends Animal implements Swim{
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Eat bones");
    }

    @Override
    public void swim() {
        System.out.println("Dog is swimming");
    }
}
