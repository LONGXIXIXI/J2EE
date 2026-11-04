package Thread;
//volatile关键字

//volatile修饰的变量能保证内存可见性
//代码在写入volatile修饰的变量的时候，
//·改变线程工作内存中volatile变量副本的值
//·将改变的副本的值从工作内存刷新到主内存

//代码在读取volatile修饰的变量的时候
//·从主内存中读取volatile变量的最新值到线程的工作内存中
//·从工作内存中读取volatile变量的副本

import java.util.Scanner;

public class Demo24 {
    static class  Counter{
        //给flag加上volatile后，当用户输入非0值时，线程循环能够立即结束
        public volatile int flag = 0;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            while(counter.flag == 0){
                //什么都不做
            }
            System.out.println("循环结束");
        });

        Thread thread2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入一个整数：");
            counter.flag = scanner.nextInt();
        });

        thread1.start();
        thread2.start();

        //synchronized和volatile负责场景是不同的
        //synchronized是处理多个线程修改，修饰代码块
        //volatile是处理一个线程修改，一个线程读的，修饰变量
        //volatile不能解决”原子性“修改的问题



        //一个线程在工作的时候，就会把需要访问的变量，从主内存拷贝到工作内存，基于工作内存做出一些逻辑判定
        //
    }
}
