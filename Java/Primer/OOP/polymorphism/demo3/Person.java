package Big_Data_Learning.Java.Primer.OOP.polymorphism.demo3;

public class Person {
    private String name;
    private int age;

    /**
     * 饲养狗
     * @param dog
     * @param sth
     */
    public void keeppet(Dog dog,String sth){
        System.out.println(getAge() + " years old keeper " + getName() + " is keeping a " + dog.getColor() + " "+dog.getAge() + " years old dog" );
        dog.eat(sth);
    }

    public void keeppet(Cat cat,String sth){
        System.out.println(getAge() + " years old keeper " + getName() + " is keeping a " + cat.getColor() + " "+ cat.getAge() + " years old dog" );
        cat.eat(sth);
    }
    public void keeppet(Animal animal,String sth){
        System.out.println(getAge() + " years old keeper " + getName() + " is keeping a " + animal.getColor() + " "+animal.getAge() + " years old dog" );
        animal.eat(sth);
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    public String toString() {
        return "Person{name = " + name + ", age = " + age + "}";
    }
}
