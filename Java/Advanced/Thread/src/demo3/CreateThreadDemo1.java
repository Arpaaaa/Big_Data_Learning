package demo3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 通过线程池来创建线程
*
*
* */
public class CreateThreadDemo1 {

    public static void main(String[] args) {
        //创建一个具有10个线程的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);  //newFixedThreadPool 可重用固定数量的线程池
        long threadPoolUseTime = System.currentTimeMillis();
        for (int i=0;i<10;i++){

            //匿名内部类-线程执行
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " Thread Working .....");

                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        long threadPoolUseTime1 = System.currentTimeMillis();
        System.out.println(" Multithread take time : " + (threadPoolUseTime1-threadPoolUseTime));
        //销毁线程池
        threadPool.shutdown();
        threadPoolUseTime = System.currentTimeMillis();
    }
}
