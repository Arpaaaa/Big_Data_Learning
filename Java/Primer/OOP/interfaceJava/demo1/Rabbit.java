package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo1;

public class Rabbit extends Animal{

    public Rabbit() {
    }

    public Rabbit(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Eat carrot");
    }
}
