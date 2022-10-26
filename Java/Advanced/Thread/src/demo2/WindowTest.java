package demo2;

/*买票过程中出现了重票和错票问题 --> 出现了线程的安全问题
* 当某个线程操作车票的过程中，在尚未完成操作时，其他进程也来操作车票了
* 解决方法：在一个线程操作车票的过程中，不让其他线程参与，直到线程操作完车票才允许其他进程操作。
*
*
* @author arpat
* @create 2022-10-17
* */


class windowT extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();   //继承Thread类创建锁对象需要保证锁的唯一性，需要加static关键字

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {    //此处obj来当锁，当前类也可以充当锁 synchronized(windowT.class),windowT.class只会加载一次
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " no of ticket : " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

class windowR implements Runnable{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this){  //此处可以直接用当前对象来充当锁即可，并且仅限于实现Runnable接口创建的线程
                // synchronized (obj) {        //由于main主线程创建了三个分线程，每个线程中都有一把锁obj，所以实际上并不能实现同步方法
                if (ticket > 0) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " no of ticket : " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest {

    public static void main(String[] args) {

        windowT w1 = new windowT();
        windowT w2 = new windowT();
        windowT w3 = new windowT();

        w1.setName("Window 1");
        w2.setName("Window 2");
        w3.setName("Window 3");

        w1.start();
        w2.start();
        w3.start();

        windowR WR = new windowR();     //w1实现Runnable接口
        Thread t1 = new Thread(WR);
        Thread t2 = new Thread(WR);
        Thread t3 = new Thread(WR);
        t1.start();
        t2.start();
        t3.start();
    }
}


