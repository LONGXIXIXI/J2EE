package Thread;
//原子类
//原子类内部用到是CAS实现，所以性能要比加锁实现高很多

import java.util.concurrent.atomic.AtomicInteger;

public class Demo36 {
    //public static int count = 0;
    //使用原子类解决线程安全的问题

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                //由于Java不支持运算符重载，针对类来说，就只能通过方法来实现功能，不能自定义运算符功能

                //count++
                count.getAndIncrement();

                //++count;
                //count.incrementAndGet();
                // count--;
                //count.getAndDecrement();
                // --count;
                //count.decrementAndGet();
                // count += n
                //count.getAndAdd(n);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count.getAndIncrement();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);

    }
}
