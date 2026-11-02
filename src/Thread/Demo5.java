package Thread;

public class Demo5 {
    public static void main(String[] args) {
        //创建线程对象
        Thread thread1 = new Thread();

        //使用Runnable对象创建线程对象
        //Thread t2 = new Thread(new MyRunnable());

        //创建线程对象，并命名
        Thread thread3 = new Thread("这是我的名字");

        //使用Runnable对象创建线程对象，并命名
        //Thread t4 = new Thread(new MyRunnable(), "这是我的名字");

        //线程组ThreadGroup
        //是Java中提供的一个机制，可以把多个线程放到一起
        //可以针对这个组里的所有线程，进行批量操作

    }
}
