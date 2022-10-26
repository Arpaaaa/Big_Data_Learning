package Big_Data_Learning.Java.Primer.OOP.polymorphism.demo3;

public class test {
    public static void main(String[] args) {
        Person p1 = new Person("arpat",20);
        Dog dog = new Dog(3,"blcak");
        p1.keeppet(dog,"bone");

        Person p2 = new Person("naela",18);
        Cat cat = new Cat(3,"brown");
        p2.keeppet(cat,"fish");

        Person p3 = new Person("nannn",30);
        Animal animal = new Animal();
        p3.keeppet(dog,"bone");
    }
}
