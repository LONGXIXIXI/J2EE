package Thread;

public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 3; i++) {
//                System.out.println("hello thread");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
            try {
                mainThread.join(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        });

        //在start之前调用的
        System.out.println(thread.getState());

        thread.start();

        //此处加上 sleep(500) 更好的确保当前的getState是在 thread 线程 sleep 过程中调用的
        Thread.sleep(500);
        System.out.println(thread.getState());

        thread.join();

        System.out.println(thread.getState());
    }
}
