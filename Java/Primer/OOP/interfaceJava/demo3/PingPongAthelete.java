package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo3;

public class PingPongAthelete extends athelete implements English {
    //constructor
    public PingPongAthelete() {
    }
    public PingPongAthelete(String name,int age){
        super(name,age);
    }
    //method
    @Override
    public void speakEnglish() {
        System.out.println("Pingpon athelete speak English");
    }

    @Override
    public void learn() {
        System.out.println("Learn PingPong");
    }
}
