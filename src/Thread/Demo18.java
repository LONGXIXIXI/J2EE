package Thread;

public class Demo18 {
    //此处定义一个int类型的变量
    public static int  count = 0;
    public static void main(String[] args) throws InterruptedException {

        //定义一个锁对象，可以是任意的对象
        Object locker1 = new Object();
        Object locker2 = new Object();
        //如果使用两个不同的锁，线程仍然是不安全的

        Thread thread = new Thread(() -> {

            //对count变量进行5w次自增
            for (int i = 0; i < 50000; i++) {
                synchronized (locker1){
                    count++;
                }
            }
        });

        Thread thread1 = new Thread(() -> {

            //对count变量进行5w次自增
            for (int i = 0; i < 50000; i++) {
                synchronized (locker1){
                    count++;
                }
            }
        });

        thread.start();
        thread1.start();

        //如果没有这两个join肯定是不行的，线程还没自增完，就开始打印了，很可能打印出来的是0
        thread.join();
        thread1.join();

        //预期结果应该是10w
        System.out.println(count);
    }
}
