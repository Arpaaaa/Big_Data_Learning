package Big_Data_Learning.Java.Primer.OOP.interfaceJava.demo4;

public interface Inter {
    /*
    1. 默认方法使用default修饰，并且不会被强制被重写
    2. 如果多个接口中有重复名称的默认方法，那么在实现类中必须重写该默认方法
    3. public可以被省略，default不会
    4. 静态方法用static修饰，并且只能用接口名调用，类似与Math.round
    5. 只能在接口中使用的方法可以用private修饰，
        private void method(){};    供默认方法使用
        private static void method(){};     供静态方法使用
     */
    public abstract void method();
    public default void show(){
        //接口中的默认方法
        System.out.println("aaa");
    }
    public static void print(int a){
        System.out.println(a);
    }
    //private 方法仅供interface中使用
    private void method2(){
        System.out.println("This is private method for default method");
    }
    private static void method3(){
        System.out.println("This is private method for static method");
    }

}
