package Thread;
//定时器

//标准库中提供了一个Timer类。Timer类的核心方法为schedule
//schedule包含两个参数，第一个参数指定即将要执行的任务代码，第二个参数指定多长时间之后执行(单位为毫秒)

import java.util.Timer;
import java.util.TimerTask;

public class Demo33 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //添加任务(可以添加多个任务)
        //第一个参数，表示要执行的任务。这个任务不是简单的Runnable，而是TimerTask
        //第二个参数, 表示多长时间之后, 执行. 单位是 毫秒
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 1");
                timer.cancel();
            }
        },4000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 2");
            }
        },3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 3");
            }
        },2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 4");
            }
        },1000);

        // 一般来说也不会让他 cancel


    }
}
