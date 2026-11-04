package Thread;
//多线程带来的风险-线程安全

public class Demo17 {
    //此处定义一个int类型的变量
    public static int  count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

            //对count变量进行5w次自增
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        Thread thread1 = new Thread(() -> {

            //对count变量进行5w次自增
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        thread.start();
        thread1.start();

        //如果没有这两个join肯定是不行的，线程还没自增完，就开始打印了，很可能打印出来的是0
        thread.join();
        thread1.join();

        //预期结果应该是10w
        System.out.println(count);
        //结果不是10w
    }
}
