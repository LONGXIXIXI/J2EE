package homework;
//使用两个线程来累加 count 的值
//每个线程循环 1w 次，累加变量 count 的值，count 默认值为 0，注意线程安全问题。
public class homework3 {
    //此处定义一个int类型的变量
    public static int  count = 0;
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();

        Thread thread = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                synchronized (locker1){
                    count++;
                }
            }
        });

        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                synchronized (locker1){
                    count++;
                }
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(count);
    }
}
