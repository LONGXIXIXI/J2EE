package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo31 {
    public static void main(String[] args) throws InterruptedException {
        //创建固定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int id = i;
            service.submit(() -> {
                System.out.println("第" + id + "个任务" + ", 线程的名字: " + Thread.currentThread().getName());
            });

        }

        Thread.sleep(1000);

        //创建一个无数量上限的线程池
        Executors.newCachedThreadPool();
        //创建一个只包含一个线程的线程池
        Executors.newSingleThreadScheduledExecutor();
        //创建一个带有定时器功能的线程池
        Executors.newScheduledThreadPool(10);
    }
}
