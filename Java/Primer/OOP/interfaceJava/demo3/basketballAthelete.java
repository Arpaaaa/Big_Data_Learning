package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo3;

public class basketballAthelete extends athelete{
    //constructor
    public basketballAthelete() {
    }

    public basketballAthelete(String name, int age) {
        super(name, age);
    }
    //method
    @Override
    public void learn() {
        System.out.println("Learn basketball");
    }
}
