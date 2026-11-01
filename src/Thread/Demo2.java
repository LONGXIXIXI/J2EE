package Thread;

import java.util.Random;

//第一个多线程程序
//感受多线程程序与普通程序的区别
//1. 每个线程都是一个独立执行流
//2. 多个线程之间是”并发“执行的

public class Demo2 {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                //打印线程名称

                System.out.println(Thread.currentThread().getName());
                try {
                    //随机停⽌运⾏0-9秒
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        Random random = new Random();
        while (true) {
            //打印线程名称

            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                //随机停⽌运⾏0-9秒
                e.printStackTrace();
            }
        }
    }
}
