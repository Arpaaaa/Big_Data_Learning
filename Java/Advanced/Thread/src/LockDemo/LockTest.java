package LockDemo;

/*解决线程安全问题的方式三： Lock锁
*
* @author arpat
* @create 2022-10-19*/

import java.util.concurrent.locks.ReentrantLock;

class Window implements Runnable{
    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();   //创建ReentrantLock 对象，一个锁，有一个参数fair判断是否公平给线程分配锁，遵循先进先出原则

    @Override
    public void run() {
        while (true){
            try {
                //调用lock方法,对同步代码上锁
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " sell ticket, no of ticket: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally {
                //解锁方法
                lock.unlock();  //如果没有写unlock()方法，那么其他线程就不能获得锁，即无法运行
            }
        }
    }
}

public class LockTest {

    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();


    }
}
