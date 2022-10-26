package Big_Data_Learning.Java.Primer.OOP.inheritance;

public class Test {

}

class Person{
    public void eat(){
        System.out.println("Person eating");
    }
}

class student extends Person{
    @Override
    public void eat(){
        System.out.println("Student eating");
    }
}

class child extends student{
    @Override
    public void eat(){
        System.out.println("childen eating 0");
    }
}