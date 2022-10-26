package demo1;

public class ThreadMethod {

    public static void main(String[] args) {
        hell th1 = new hell();
        //给分线程换名字
        th1.setName("Thread One");
        th1.start();

        Thread.currentThread().setName("Main Thread : ");
        System.out.println(Thread.currentThread().getName()+ "hhhh");
    }

}

class hell extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"this is hell");
    }
}
