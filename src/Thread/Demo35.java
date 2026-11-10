package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//Callable 接⼝
//Callable是一个interface。相当于把线程封装了一个返回值。方便程序员借助多线程的方式计算结果

public class Demo35 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个匿名内部类，实现Callable接口，Callable带有泛型参数。泛型参数表述返回值的类型
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            //重写Callable的call方法，完成累加的过程，直接通过返回值返回计算结果
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        //把callable实列使用Future包装一下
        FutureTask<Integer> task = new FutureTask<>(callable);

        //创建线程，线程的构造方法传入Futuretask，此时新线程就会执行FutureTask内部的Callable的call方法，完成计算，计算结果就放了FutureTask对象中
        Thread thread = new Thread(task);
        thread.start();

        //在主线程中调用task.get()能够阻塞等待新线程计算完毕。并获取到FutureTask中的结果
        int result = task.get();
        System.out.println(result);
    }
}
