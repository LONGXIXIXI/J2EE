package Thread;
//第一个多线程程序

import java.util.TreeMap;

//创建线程的方法
//方法1：继承Thread类来创建一个线程类，创建MyThread类的实例
class MyThread extends Thread{

    //重写run方法
    //run 代表线程的入口，线程运行起来之后，要执行什么样的逻辑
    public void run(){
        while(true){
            System.out.println("hello thread");
            try {
                //停止运行1s
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}

//方法2：实现Runnable接口，创建Thread类实例，调用Thread的构造方法时将Runnable对象作为参数
class MyRunnable implements Runnable{

    public void run(){
        while(true){
            System.out.println("hello thread2");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}



public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        //使用这个线程
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new MyRunnable());
        thread.start();

        while(true){
            System.out.println("hello world");
            Thread.sleep(1000);
        }
    }
}
