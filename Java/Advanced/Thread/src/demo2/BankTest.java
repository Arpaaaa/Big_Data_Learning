package demo2;

/* 使用同步机制将单例模式中的懒汉式改写为线程安全的
*   单例模式：只能创建一个实例，如果已经有了实例，就不能在创建实例*/
public class BankTest {

}

class Bank{

    private Bank(){}

    private static Bank instance = null;
    //只能创建一个实例，此时为线程不安全,添加synchronized 之后成为线程安全的
    public static synchronized Bank getInstance(){
        if (instance==null){
            instance = new Bank();
        }
        return instance;
    }
    /*另一种方法
    * 使用同步代码块来解决线程安全问题效率较低
    * public static Bank getInstance(){
    *   synchronized(Bank.class){
    *      if (instance==null){
            instance = new Bank();
        }
        return instance;
       }
    * */
}
