package Big_Data_Learning.Java.Primer.OOP.inheritance;

public class AnimalDemo {
    private void eat(){
        System.out.println("eating");
    }
    private void drink(){
        System.out.println("drinking");
    }
}

class Cat extends AnimalDemo{
    private void grabMouse(){
        System.out.println("Grabing Mouse");
    }
}

class bocat extends Cat{

}
class chineseLiHuaCat extends Cat{

}

class Dog extends AnimalDemo{
    public void eat(){}
    private void gardHouse(){
        System.out.println("garding the house");
    }
}

class husky extends Dog{
    @Override
    public void eat(){
        System.out.println("吃 狗粮");
    }
    private void chaijia(){}
}

class taidi extends Dog{
    private void cenyicen(){
        System.out.println("ceng yi ceng ");
    }

}

