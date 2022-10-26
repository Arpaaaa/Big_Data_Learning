package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo3;

public abstract class athelete extends Person{
    public athelete() {
    }

    public athelete(String name, int age) {
        super(name, age);
    }

    public abstract void learn();
}
