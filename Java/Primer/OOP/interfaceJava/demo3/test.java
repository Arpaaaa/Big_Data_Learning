package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo3;

public class test {
    public static void main(String[] args) {
        PingPongAthelete pps = new PingPongAthelete("Liushiwen",23);
        System.out.println(pps.getName()+" , "+pps.getAge());
        pps.learn();
        pps.speakEnglish();
    }
}
