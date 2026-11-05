package homework;
//有三个线程，分别只能打印A，B和C
//要求按顺序打印ABC，打印10次

//输出示例：
//ABC
//ABC
//ABC
//ABC
//ABC
//ABC
//ABC
//ABC
//ABC
//ABC

public class homework5 {
    public static Object locker = new Object();

    public static int flag = 0;
    public static void main(String[] args) {

        Thread A = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (locker){
                    while(flag != 0){
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(Thread.currentThread().getName());
                    flag = 1;
                    locker.notifyAll();
                }

            }
        },"A");

        Thread B = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (locker){
                    while(flag != 1){
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(Thread.currentThread().getName());
                    flag = 2;
                    locker.notifyAll();
                }

            }
        },"B");

        Thread C = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (locker){
                    while(flag != 2){
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName());
                    flag = 0;
                    locker.notifyAll();
                }

            }
        },"C");

        A.start();
        B.start();
        C.start();


    }
}
