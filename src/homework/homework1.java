package homework;
//1.给定一个很长的数组 (长度 1000w), 通过随机数的方式生成 1-100 之间的整数.
//2.实现代码, 能够创建两个线程, 对这个数组的所有元素求和.
//3.其中线程1 计算偶数下标元素的和, 线程2 计算奇数下标元素的和.
//4.最终再汇总两个和, 进行相加
//5.记录程序的执行时间.

import java.util.Random;

public class homework1 {
    public static int count1 = 0;
    public static int count2 = 0;
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        int[] arr = new int[1000_0000];

        for (int i = 0; i < 1000_0000; i++) {
            arr[i] = random.nextInt(100) + 1;
        }

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000_0000; i++) {
                if(i % 2 == 0){
                    count1 += arr[i];
                }
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000_0000; i++) {
                if(i % 2 == 1){
                    count2 += arr[i];
                }
            }
        });

        long start = System.nanoTime();

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        long end = System.nanoTime();

        System.out.println("总和：" + (count1 + count2));
        System.out.printf("求和耗时：%.3f 毫秒%n",
                (end - start) / 1_000_000.0);
    }
}
