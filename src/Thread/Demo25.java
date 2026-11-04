package Thread;
//wait 和notify
//由于线程之前是抢占式执行的，因此线程之间执行的先后顺序难以预知。
//但是实际开发中有时候我们希望合理的协调多个线程之间的执行先后顺序
//完成这个协调工作，主要涉及到三个方法
//·wait()/wait(long timeout):让当前线程进入等待状态
//·notify()/notifyAll():唤醒在当前对象上等待的线程
//wait,notify, notifyAll 都是 Object 类的⽅法.


import java.util.Scanner;

public class Demo25 {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread thread1 = new Thread(() -> {
            //wait()方法
            //wait做的事情
            //·使当前执行代码的线程进行等待(把线程放到等待队列中)
            //·释放当前的锁
            //·满足一定条件时被唤醒，重新尝试获取这个锁
            //wait要搭配synchronized来使⽤.脱离synchronized使⽤wait会直接抛出异常.

            //wait结束等待的条件：
            //·其他线程调用该对象的notify方法
            //·wait等待时间超时(wait方法提供一个带有timeout参数的版本，来指定等待时间)
            //·其他线程调用该等待线程的interrupted方法，导致wait抛出InterruptedException异常
            synchronized (locker){
                System.out.println("thread1等待前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread1等待结束");
            }
        });

        //这样在执⾏到object.wait()之后就⼀直等待下去，那么程序肯定不能⼀直这么等待下去了。这个时候就
        //需要使⽤到了另外⼀个⽅法唤醒的⽅法notify()。

        Thread thread2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入任意内容唤醒 t1");
            scanner.next();

            //notify()方法
            //notify方法是唤醒等待的线程
            //·方法notify()也要在同步方法或同步块中调用，该方法是用来通知那些可能等待该对象的对象锁的其他线程，对其他发出通知notify，并使它们重新获取该对象的对象锁
            //·如果有多个线程等待，则有线程调度器随机挑选出一个呈wait状态的线程
            //·在notify()方法后，当前线程不会马上释放该对象锁，要等到执行notify()方法的下称将程序执行完，也就是推出同步代码块之后才会释放对象锁
            synchronized (locker){
                locker.notify();
            }

        });

        thread1.start();
        thread2.start();


        //notifyAll()⽅法
        //notify⽅法只是唤醒某⼀个等待线程.使⽤notifyAll⽅法可以⼀次唤醒所有的等待线程.

    }
}
