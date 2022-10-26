package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo1;

public class test {
    public static void main(String[] args) {
        Frog frog = new Frog("Jack",1);
        System.out.println(frog.getName()+","+ frog.getAge());

        frog.eat();
        frog.swim();

        Rabbit rabbit = new Rabbit("Rose",2);
        System.out.println(rabbit.getName()+","+rabbit.getAge());
        rabbit.eat();
    }


}
