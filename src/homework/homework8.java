package homework;
//编写代码, 基于 CountDownLatch 模拟跑步比赛的过程

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class homework8 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch readyLatch = new CountDownLatch(8);

        CountDownLatch startLatch = new CountDownLatch(1);

        CountDownLatch endLatch = new CountDownLatch(8);

        for (int i = 0; i < 8; i++) {
            int id = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(id + "号选手准备就绪");
                    readyLatch.countDown();

                    startLatch.await();

                    System.out.println(id + "号选手开始跑步");

                    int time = ThreadLocalRandom.current().nextInt(1000, 5001);

                    Thread.sleep(time);
                    System.out.println(id + "号到达终点，耗时：" + time);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    endLatch.countDown();
                }

            });
            thread.start();
        }

        readyLatch.await();
        System.out.println("裁判：预备，开始！");
        startLatch.countDown();



        endLatch.await();
        System.out.println("裁判：所有运动员均已结束比赛！");
    }
}
