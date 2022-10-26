package demo1;
/* 多线程的创建， 方式一：继承Thread类
*  1. 创建一个继承Thread类的子类
*  2. 重写Thread类的run() 方法 --> 将创建的线程需要执行的操作声明在run()方法中
*  3. 创建子类的对象
*  4. 通过子类对象调用start()方法
*  */

class myThread extends Thread{
    /*Example:打印1~100的偶数*/
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}
public class NewThread {
    public static void main(String[] args) {
        myThread thread = new myThread();   // ---> 主线程完成

        //调用start()来启动线程并调用当前线程的run()
        //thread.start();     //--->主线程完成
        thread.start();     // 不能写run()，因为只有start()才能启动线程

        //问题2：再次启动一个线程，调用start()可以吗？
        //答：线程在启动之后不能再次启动 ，若需要线程则应该创建多个线程进行工作



        //主线程任务
        for (int i=0;i<50;i++){
            if (i%2==0){
                System.out.println(i+"*******");
            }
        }

    }
}
