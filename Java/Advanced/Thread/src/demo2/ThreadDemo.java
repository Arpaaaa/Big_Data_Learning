package demo2;

/*创建多线程的方式二：实现runnable接口
* 1. 创建一个实现runnable接口的类
* 2. 实现类去实现接口中的抽象方法run()
* 3. 创建实现类的对象
* 4. 将此对象作为参数传给Thread类构造器，创建Thread对象
* 5. 通过Thread类对象调用start()
* */


class MThread implements Runnable{
    //重写接口中的run方法
    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MThread mThread = new MThread();    //创建MThread类对象
        Thread t1 = new Thread(mThread);    //创建线程对象
        t1.start();     //调用线程对象的run方法，启动该线程

        //如果需要再创建一个线程，则可以
        Thread t2 = new Thread(mThread);
        t2.start();
    }
}
