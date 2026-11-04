package homework;
//有20个线程，需要同时启动。
//每个线程按0-19的序号打印，如第一个线程需要打印0
//请设计代码，在main主线程中，等待所有子线程执行完后，再打印 ok

public class homework2 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];

        for (int i = 0; i < 20; i++) {
            final int num = i;
            threads[i] = new Thread(() -> {

                System.out.println(num);
            });
        }

        for(Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        System.out.println("OK");
    }
}
