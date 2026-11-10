package Thread;
//信号量Semaphore-用来表示”可用资源个数“

import java.util.concurrent.Semaphore;

public class Demo37 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "申请资源");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() +"我获取到资源了");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() +"我释放资源了");
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }

    }
}
