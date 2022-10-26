package demo2;

public class synchronizeMethodDemo {



}

class wT extends Thread {
    private static int ticket = 100;
    /*使用同步方法来解决继承Thread类线程的安全问题*/

    @Override
    public void run() {
        while (true){
            sellTicket2();
        }
    }

    public static synchronized void sellTicket2(){      //将同步方法设置为静态static和synchronized,此时同步监视器是当前这个类
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " no of ticket : " + ticket);
            ticket--;
        }
    }

}


class wR implements Runnable{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
                sellTicket();
            }
    }
    private synchronized void sellTicket(){     //将方法sellTicket 声明为synchronized，同步监视器是this
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " no of ticket : " + ticket);
            ticket--;
        }
    }
}
