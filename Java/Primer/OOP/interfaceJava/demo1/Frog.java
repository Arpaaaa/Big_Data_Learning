package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo1;

public class Frog extends Animal implements Swim{
    public Frog() {
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Eat worm");
    }

    @Override
    public void swim() {
        System.out.println("Frog is swimming");
    }
}
