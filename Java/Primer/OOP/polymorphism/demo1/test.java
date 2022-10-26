package Big_Data_Learning.Java.Primer.OOP.polymorphism.demo1;

public class test {
    public static void main(String[] args){
        //创建对象并调用方法
        student s = new student();
        s.setAge(18);
        s.setName("arpat");

        teacher t = new teacher();
        t.setAge(30);
        t.setName("xiaomei");

        administrator ad = new administrator();
        ad.setAge(25);
        ad.setName("Jack");

        register(s);
        register(t);
        register(ad);
    }

    //既能接收老师和学生还能接收管理员
    public static void register(Person person){
        person.show();
    }
}
