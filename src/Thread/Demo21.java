package Thread;
//规避死锁
//1.锁是“互斥”的
//synchronized是互斥的，这个条件自动具备，但不代表所有锁都是互斥的

//2.锁不可被抢占
//线程1获取锁A，线程2也尝试获取锁A，此时线程2阻塞等待，一直等到线程1释放锁A，线程2不能强行把锁A抢夺过来，对于synchronized来说，这个条件也是自动具备的

//3.请求与保持
//一个线程，获取到锁A，在持有锁A的情况下，再去获取锁B
//如果通篇只有一把锁，是在可重入的情况下，就不会死锁
//即使有多把锁，如果不去嵌套使用，也不会死锁

//4.循环等待/环路等待
//即使有多个锁，请求保持的方式进行使用了，得是多个线程的等待锁的顺序，出现循环了，才会产生死锁，如果不是循环等待就不会死锁
//对于Demo20的实例，约定好获取锁的顺序就可以避免死锁
public class Demo21 {
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
            synchronized (lockerA){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lockerB){
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
