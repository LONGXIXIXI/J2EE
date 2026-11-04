package Thread;
//死锁的场景
//1.一个线程，一把锁，对锁加锁两次 (可重入锁已经解决)
//2.两个线程，两把锁
//3.M个线程，N把锁(哲学家就餐问题)

public class Demo20 {
    public static void main(String[] args) {
        Object lockerA = new Object();
        Object lockerB = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lockerA){
                try {
                    //加sleep是为了确保对方线程已经把锁拿到了
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lockerB){
                    System.out.println("hello thread1");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lockerB){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lockerA){
                    System.out.println("hello thread2");
                }
            }


        });

        thread1.start();
        thread2.start();

        //在jconsole中查看两个线程的状态都是BLOCKED

        System.out.println("hello main");

    }
}
