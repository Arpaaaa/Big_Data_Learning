package Big_Data_Learning.Java.Primer.OOP.polymorphism.demo3;

public class Cat extends Animal{
    private int age;
    private String color;

    public void eat(String sth){
        System.out.println(age + " years old cat is eating " + sth);
    }
    public void catchMouse(){
        System.out.println("Catch mouse");
    }

    public Cat() {
    }

    public Cat(int age, String color) {
        this.age = age;
        this.color = color;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Cat{age = " + age + ", color = " + color + "}";
    }
}
