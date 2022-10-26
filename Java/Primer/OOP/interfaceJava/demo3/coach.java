package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo3;

public abstract class coach extends Person{
    public coach() {
    }

    public coach(String name, int age) {
        super(name, age);
    }

    public abstract void teach();
}
