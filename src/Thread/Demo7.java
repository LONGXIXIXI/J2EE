package Thread;

//前台线程：这个线程如果没执行完，此时进程就不会结束，前台进程会阻止进程结束
//后台线程：这个线程执行完或执行不完，都不会影响进程的结束
//代码中创建的线程，默认是前台线程。包括main线程也是前台线程，JVM自带的线程是后台线程

public class Demo7 {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->{
            while(true){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"这是一个线程");

        //默认是前台线程，可以使用setDaemon修改为后台线程，一定是在start之前修改
        thread.setDaemon(true);
        thread.start();
        //此时只有一个前台线程,main线程，main线程结束了，整个进程就结束了。
    }
}
