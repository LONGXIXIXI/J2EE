package homework;

import java.util.concurrent.*;

//Java 标准库线程池的创建方式总共有几种？分别使用代码创建并演示一下

public class homework6 {

    public static void main(String[] args) throws Exception {

//        // 1. 固定大小线程池
//        System.out.println("固定线程池：");
//        ExecutorService pool1 = Executors.newFixedThreadPool(3);
//
//        for (int i = 0; i < 5; i++) {
//            int index = i;
//            pool1.execute(() -> {
//                System.out.println("任务" + index + "：" +
//                        Thread.currentThread().getName());
//            });
//        }
//
//        pool1.shutdown();
//        pool1.awaitTermination(5, TimeUnit.SECONDS);


//        // 2. 缓存线程池
//        System.out.println("缓存线程池：");
//        ExecutorService pool2 = Executors.newCachedThreadPool();
//        // 提交5个任务
//        for (int i = 0; i < 5; i++) {
//            int index = i;
//            pool2.submit(() -> {
//                System.out.println("任务" + index + ":" + Thread.currentThread().getName());
////                try {
////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    Thread.currentThread().interrupt();
////                }
//            });
//        }
//        pool2.shutdown();
//        pool2.awaitTermination(5, TimeUnit.SECONDS);


//        // 3. 单线程线程池
//        System.out.println("单线程线程池：");
//        ExecutorService pool3 = Executors.newSingleThreadExecutor();
//
//        for (int i = 0; i < 5; i++) {
//            int index = i;
//            pool3.execute(() -> {
//                System.out.println("任务" + index + "：" + Thread.currentThread().getName());
//            });
//        }
//
//        pool3.shutdown();

//        pool3.awaitTermination(5, TimeUnit.SECONDS);


        // 4. 定时线程池
        System.out.println("定时线程池：");
        ScheduledExecutorService pool4 =
                Executors.newScheduledThreadPool(2);

        ScheduledFuture<?> future = pool4.schedule(() -> {
            System.out.println("延迟1秒执行：" + Thread.currentThread().getName());
        }, 1, TimeUnit.SECONDS);

        future.get();
        pool4.shutdown();
    }
}