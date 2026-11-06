package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class MyThreadPoolExecutor{
    private static BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

    public MyThreadPoolExecutor(int n){
        //需要根据当前指定的参数，创建出若干个线程
        //创建出的线程要能执行任务
        Thread thread = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                //循环的从上述队列中取元素
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
}

public class Demo32 {
    public static void main(String[] args) {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(10);
        try {
            for (int i = 0; i < 1000; i++) {
                int index = i;
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("第" + index + "个任务" + ",线程的名字：" + Thread.currentThread().getName());
                    }
                });
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
