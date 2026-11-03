package Thread;
//关注WAITING,BLOCKED,TIMED_WAITING状态的切换

//BLOCKED表示等待获取锁，WAITING和TIMED_WAITING表示等待其他线程发来通知
//TIMED_WAITING线程等待唤醒，但设置了时限；WAITING线程在无限等待唤醒

public class Demo15 {
    public static void main(String[] args) {
        final Object object = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    while(true){
                        try {
                            //object.wait();
                            //使用jconsole就可以看到thread1的状态是WAITING

                            Thread.sleep(1000);
                            //使用jconsole可以看到thread1的状态是TIMED_WAITING,thread2的状态是BLOCKED
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        },"thread1");

        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("hehe");
                }
            }
        }, "thread2");
        thread2.start();
    }
}
