package demo3;

/*创建线程的方式：实现Callable接口 ---JDK5.0新增
* 如何理解实现Callable接口比Runnable接口更强大？
* Future接口*/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumThread implements Callable{
    //将线程需要执行的操作声明在call()方法中
    @Override
    public Object call() throws Exception {
        //遍历1-100，并返回合
        Integer sum = 0;
        for (int i =1;i<=100;i++){
            if (i%2==0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


public class NewThread {

    public static void main(String[] args) {
        NumThread numThread = new NumThread();  //创建线程对象
        FutureTask futureTask = new FutureTask(numThread);     //以线程为参数创建FutureTask类对象
        Thread thread = new Thread(futureTask);     //将FUtureTask类对象作为参数创建线程Thread类对象
        thread.start();

        try {
            Object sum = futureTask.get();  //get()方法的返回值即为FutureTask构造器参数Callable实现类重写的call()返回值
            System.out.println("The sum of : " + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
