package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

//CountDownLatch-同时等待N个任务执行结束
public class Demo38 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(8);

        for (int i = 0; i < 8; i++) {
            int id = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("任务开始" + id);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5001));
                    System.out.println("任务结束" + id);
                    latch.countDown();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
            thread.start();
        }

        latch.await();
        System.out.println("所有任务都结束了");

    }
}
