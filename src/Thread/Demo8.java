package Thread;
import java.util.Scanner;
//中断一个线程常见的有两种方式
//1. 通过共享标记来进行沟通
//2. 调用interrupt()方法来通知

//第一种方式:使用自己定义的变量来作为标志位
public class Demo8 {

    public static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        //boolean isQuit = false;
        //被 Lambda 捕获的局部变量必须是 final，或“事实上不再改变”的 effectively final。

        Thread thread = new Thread(() -> {
            //如果这个线程瞬间执行完毕，就谈不上”终止“，其他线程中根本就没来得及操作
            //通过while模拟执行很长的情况
            while(!isQuit){
                System.out.println(Thread.currentThread().getName() + ":别管我，我忙着转账呢！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + ":啊！险些误了大事");
        },"李四");

        System.out.println(Thread.currentThread().getName() + ":让李四开始转账");

        thread.start();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ":老板来电话了，得赶紧通知李四对方是个骗子");
        isQuit = true;
    }
}
