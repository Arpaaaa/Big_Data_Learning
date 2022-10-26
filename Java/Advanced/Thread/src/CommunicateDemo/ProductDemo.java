package CommunicateDemo;

/* 生产者 消费者问题
* 分析
* 是否是多线程：是，生产者和消费者两个线程
* 是否有共享数据：有，产品或者店员
* 如何处理线程安全问题：同步机制三种方法
* 如何处理线程的通信：如果产品==20，则让生产者wait，如果产品==0，则让消费者wait*/

class Clerk{
    private int product = 0;

    //produce product
    public synchronized void produceProduct() {

        if (product<20) {
            product++;
            System.out.println(" Start produce the :"+ product + " product ");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //consume product
    public synchronized void consumeProduct() {
        if (product>0){
            System.out.println(" Start consume the : " + product + " product ");
            product--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Producer extends Thread{

    private Clerk clerk = new Clerk();

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" :start producing...");

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            clerk.produceProduct();
        }
    }

}

class Customer extends Thread{
    private Clerk clerk = new Clerk();

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + " : start consuming...");
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.consumeProduct();
        }
    }
}
public class ProductDemo {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        producer.setName("producer 1");
        Customer customer = new Customer(clerk);
        customer.setName("customer 1");

        producer.start();
        customer.start();
    }
}
