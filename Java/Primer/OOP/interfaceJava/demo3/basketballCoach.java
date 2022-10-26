package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo3;

public class basketballCoach extends coach{
    //constructor
    public basketballCoach() {
    }

    public basketballCoach(String name, int age) {
        super(name, age);
    }
    //method
    @Override
    public void teach() {
        System.out.println("teach how to play basketball");
    }
}
