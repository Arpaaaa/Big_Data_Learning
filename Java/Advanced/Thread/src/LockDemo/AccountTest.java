package LockDemo;
/*
* 银行有一个账户，有两个储户分别向同一个账户存3000元，每次存1000，存3次，每次存完打印账户余额
* 线程安全的解决方法：
*  ① 将Account类中的deposit方法设置为synchronized 同步方法，或者将该方法内部的代码块使用synchronized上锁
*       public void synchronized deposit()
*  ② 使用ReentrantLock类创建lock对象，并且手动在deposit方法中对对代码区进行lock和unlock操作
*       try{
*           lock.lock
*           more code
*        }finally{
*           lock.unlock
*        }*/

import java.util.concurrent.locks.ReentrantLock;

class Account{
    private double balance;
    //由于使用继承Thread类创建线程，所以要把lock设为静态的，目的是为了多个线程能同用一把锁
    private static ReentrantLock lock = new ReentrantLock(true);

    public Account(double balance){
        this.balance = balance;
    }
    public Account(){}

    //存钱
    public void deposit(double amt){
        try {
            lock.lock();

            if (amt > 0) {
                balance += amt;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + " : Deposit successfully and balance is : " + balance);
            }
        }finally {
            lock.unlock();
        }
    }
}

class Customer extends Thread{
    private Account account;


    public Customer(Account account){
        this.account = account;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}


public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account();
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("Jack");
        c2.setName("Rose");

        c1.start();
        c2.start();

    }
}
