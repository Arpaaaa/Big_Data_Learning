package Big_Data_Learning.Java.Primer.OOP.InnerClass;

public class StaticInner {
    /*
    * 静态内部类只能访问外部类中的静态变量和静态方法，如需访问非静态的需要创建对象
    * */
    public static void main(String[] args) {

    }
    int a = 10;
    static int b = 20;
    static class Inner{
        public void show(){
            StaticInner o = new StaticInner();
            System.out.println(o.a);
            System.out.println("Non static method is used");
        }
        public void show2(){
            System.out.println(b);
            System.out.println("Static method is used");
        }
    }

}
