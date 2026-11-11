package homework;
//编写代码实现两个线程增加同一个变量,使用 Semphore 来控制线程安全.

import java.util.concurrent.Semaphore;
public class homework7 {
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50000; i++) {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                for (int i = 0; i < 50000; i++) {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(count);

    }
}
