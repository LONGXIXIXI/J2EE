package Thread;

public class Demo11 {
    public static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        //让这个线程从1+2+3+...+1000
        //主线程中打印这个结果
        Thread thread = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i <= 1000; i++) {
                sum +=i;
            }
            result = sum;
        });

        thread.start();

//        Thread.sleep(1000);
//        while(result == 0){
//            Thread.sleep(1);
//        }

        thread.join();

        System.out.println(result);

    }
}
