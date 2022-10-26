package CommunicateDemo;

/*
* 使用两个线程打印1-100 交替打印
* 涉及到的三个方法:
* wait():一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器
* notify():一旦执行此方法，就会唤醒被wait()的一个线程，如果有多个线程被wait，就唤醒优先级较高者
* notifyAll():唤醒所有被wait()的线程
*
* 注意点:
* ① 上述三个方法是关于进程通信的方法，使用这些方法的前提是这三个方法都必须要在同步代码块或同步方法中使用
* ② 这三个方法的调用者必须是同步代码块或同步方法中的同步监视器，否则会出现IllegalMonitorStateException异常
* ③ 这三个方法定义在Object类当中
*
* 面试题：sleep() 方法和wait()方法的异同
* */

class Number implements Runnable{
    private int number = 1;

    @Override
    public void run() {
        while (true){
            synchronized (this) {   //this是同步监视器

                notify();   //唤醒阻塞的线程，默认this.notify()，此处必须是同步监视器调用notify

                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + " : " + number);
                    number++;
                    try {
                        wait();     //将调用wait()的线程进行阻塞，并且线程一旦执行wait()方法就会释放锁,this.wait()必须是同步监视器调用wait()方法
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicateTest {

    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();

    }
}
