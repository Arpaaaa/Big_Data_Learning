package demo1;
/*创建两个分线程，分别遍历啊100以内的偶数和奇数*/

public class ThreadDemo {

    public static void main(String[] args) {
        thread1 t1 = new thread1();
        thread2 t2 = new thread2();

        //start thread
        t1.setPriority(10);

        t1.start();
        //t2.start();

        new Thread(){
            /*匿名子类的方式创建线程*/

            @Override
            public void run() {
                System.out.println("This is new thread");
            }
        }.start();


        System.out.println(t1.isAlive());
        System.out.println("--------Threads are working ---------");
        Thread.currentThread().setPriority(1);
        for (int i=0;i<=100;i++){
            if (i%2==0){
                System.out.println(thread1.currentThread().getName()+":"+i);
            }
            if (i % 20==0){
                try {
                    t1.join();      //在主线程运行过程中，插入另一个线程t1来运行，在t1进程运行结束之前，主线程不能执行
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(Thread.currentThread().getPriority() + " main thread ");
        System.out.println(" t1 : " + t1.getPriority());   //获取优先级
        System.out.println(t1.isAlive());

    }
}

class thread1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%2==0){
                /*try {
                    sleep(200); //让进程”睡眠“ 指定时间再执行，在指定时间之内线程处于阻塞状态
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                System.out.println(thread1.currentThread().getName()+":"+i);
            }
            if (i % 20==0){
                this.yield();
            }
        }
    }
}
class thread2 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%2==1){
                System.out.println(thread2.currentThread().getName()+":"+i);
            }
        }
    }
}
