package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo3;

public class pingpongCoach extends coach implements English{
    //constructor
    public pingpongCoach() {
    }

    public pingpongCoach(String name, int age) {
        super(name, age);
    }
    //method
    @Override
    public void speakEnglish() {
        System.out.println("Pingpong coach learn english");
    }

    @Override
    public void teach() {
        System.out.println("Pingpong Coach teach how to play pingpong");
    }
}
