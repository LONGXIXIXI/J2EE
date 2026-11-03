package Thread;
//中断一个线程常见的有两种方式
//1. 通过共享标记来进行沟通
//2. 调用interrupt()方法来通知


//第二种方式：使用Thread.interrupted()或者Thread.currentThread().isTnterrupted()代替自定义标志位.
//Thread内部包含了一个boolean类型的变量作为线程是否被中断的标记

//      方法                                          说明
//  public void interrupt()                     中断对象关联的线程，如果线程正在阻塞，则以异常方式通知，否则设置标志位
//  public static boolean interrupted()         判断当前线程的中断标志位是否设置，调用后清除标志位
//  public boolean isInterrupted()              判断对象关联的线程的标志位是否设置，调用后不清除标志位

//thread收到通知的方式有两种：
//1.如果线程因为调用wait/join/sleep等方法而阻塞挂起，则以InterruptedException异常的形式通知，清除中断标志
//2.否则，只是内部的⼀个中断标志被设置，thread可以通过Thread.currentThread().isInterrupted()判断指定线程的中断标志被设置，不清除中断标志这种⽅式通知收到的更及时，即使线程正在sleep也可以⻢上收到。


public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            //通过isInterrupted()判定线程是否被终止，此处不能直接使用thread，使用Thread.currentThread()来代替
            while(!Thread.currentThread().isInterrupted()){
                //while(!Thread.interrupted())也可以
                System.out.println(Thread.currentThread().getName() + "：别管我，我忙着转账呢");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //1.立即终止线程
                    //break;

                    //2.稍后处理
                    // 先执行一些其他操作，比如释放资源收尾操作
                    //然后再break

                    //3.不处理，忽略了终止请求


                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName() + "：有内鬼，终止交易！");
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "：啊！险些误了大事");
        },"李四");

        System.out.println(Thread.currentThread().getName() + ":让李四开始转账");
        thread.start();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ":老板来电话了，得赶紧通知李四对方是个骗子");

        //终止t线程
        thread.interrupt();


    }
}
