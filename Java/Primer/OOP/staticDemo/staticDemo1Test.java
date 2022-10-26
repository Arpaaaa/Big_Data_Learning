package Big_Data_Learning.Java.Primer.OOP.staticDemo;



public class staticDemo1Test {
    public static void main(String[] args){
        staticDemo1 student1 = new staticDemo1();
        student1.setName("arpat");
        student1.setAge(23);
        student1.setGender("male");
        student1.teachername = "ll";

        student1.study();
        System.out.println(student1.toString());


        staticDemo1 student2 = new staticDemo1();
        student2.setName("naela");
        student2.setAge(22);
        student2.setGender("female");

        student2.study();
        System.out.println(student2.toString());

    }
}
