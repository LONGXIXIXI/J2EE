package Thread;
//内存可见性引起的线程安全问题

import java.util.Scanner;

public class Demo23 {
    public static boolean flag = true;

    //这个代码是有线程安全问题的
    //此处的问题就是编译器优化，在多线程环境下，产生“误判”，导致优化后的逻辑不一样了

    //1.load是读取内存，开销要远远高于cmp操作
    //2.循环多次之后发现，每次load到的结果都是一样的
    //3.编译器在当前线程中，没有发现修改操作
    //此时编译器会触发优化，就会把load操作优化成读取cpu寄存器/cpu缓存(不去正真读取内存数据了)
    //修改操作在另一个线程，此时编译器不知道这个修改到底能不能真的执行到
    //t2线程把内存修改了，但是t1感知不到，这个内存flag的变化对t1线程“不可见“

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while(flag){
                //什么都不做

                //只要让while循环中，load时间占比变低，此时就不容易触发优化了
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
            System.out.println("thread结束");
        });

        Thread thread2 = new Thread(() -> {
            //让用户进行输入，根据用户输入，修改flag
            System.out.println("请输入任意内容，终止线程thread1");
            Scanner scanner = new Scanner(System.in);
            scanner.next();
            //通过修改flag让thread1结束。
            flag = false;
            System.out.println("flag" + flag);
        });

        thread1.start();
        thread2.start();



    }
}
