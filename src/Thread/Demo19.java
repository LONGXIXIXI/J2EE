package Thread;
//synchronized关键字
//synchronized的特性
//1.互斥
//synchronized会起到互斥效果,某个线程执⾏到某个对象的synchronized中时,其他线程如果也执⾏到同⼀个对象synchronized就会阻塞等待.

//2.可重入
//synchronized 同步块对同⼀条线程来说是可重⼊的，不会出现⾃⼰把⾃⼰锁死的问题
//可重入锁并不能解决所有的死锁情况
public class Demo19 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread thread = new Thread(() -> {

            //Java 中的synchronized是可重⼊锁,因此没有上⾯的问题.
            //在可重⼊锁的内部,包含了"线程持有者"和"计数器"两个信息
            //如果某个线程加锁的时候，发现锁已经被人占用，但恰好占用正是自己，那么仍然可以继续获取到锁，并让计数器自增
            //解锁的时候计数器递减为0的时候，才真正释放锁
            for (int i = 0; i < 10; i++) {
                synchronized (locker){
                    synchronized (locker){
                        System.out.println("hello thread");
                    }
                }
            }
        });

        thread.start();

        System.out.println("hello main");
    }
}
