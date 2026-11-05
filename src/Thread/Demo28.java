package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//生产者消费者模型
//编写一个生产者消费者模型
public class Demo28 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1000);

        //生产者和消费者都是线程
        Thread producer = new Thread(() -> {
            try {
                int count = 0;
                 while(true){
                     count++;
                     queue.put(count + " ");
                     System.out.println("生产元素：" + count);

                     //生产速度慢了，消费者就需要等待生产者
                     //Thread.sleep(1000);
                 }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while(true){
                    System.out.println("消费元素" + queue.take());
                    //消费者的速度慢了，生产者就需要等待消费者
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
