package Thread;

//    方法                                            说明
//  public void join()                              等待线程结束
//  public void join(long millis)                   等待线程结束，最多等待millis毫秒
//  public void join(long millis, int nanos)        同理，但可以精度更高

public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Runnable target = () ->{
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":我还在工作！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "：我结束了！");
        };

        Thread thread1 = new Thread(target,"李四");
        Thread thread2 = new Thread(target,"王五");

        System.out.println("先让李四开始工作");
        thread1.start();
        thread1.join();
        System.out.println("李四工作结束了，让王五开始工作");
        thread2.start();
        thread2.join();
        System.out.println("王五工作结束了");

    }
}
