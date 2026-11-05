package Thread;

import java.util.concurrent.*;

//阻塞队列
//阻塞队列是一种特殊的队列，也遵守先进先出的原则
//阻塞队列能是一种线程安全的数据结构，并且具有以下特性
//·当队列满的时候，继续入队列就会阻塞，知道有其他线程从队列中取走元素
//·当队列空的时候，继续出队列也会阻塞，知道有其他线程往队列中插入元素
public class Demo27 {
    public static void main(String[] args) throws InterruptedException {
        //有三个子类选择
        //new ArrayBlockingQueue<>();
        //new LinkedBlockingQueue<>();
        //new PriorityBlockingQueue<>();

        //capacity初始容量(对于数组版本来说，不能扩容)
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(4);
        queue.put("111");
        queue.put("222");
        queue.put("333");
        queue.put("444");
        System.out.println("添加四次");

        //第五次添加就会产生阻塞
//        queue.put("555");
//        System.out.println("添加第五次");

        String ret;
        ret = queue.take();
        System.out.println(ret);
        ret = queue.take();
        System.out.println(ret);
        ret = queue.take();
        System.out.println(ret);
        ret = queue.take();
        System.out.println(ret);

        //第五次take就会产生阻塞
        ret = queue.take();
        System.out.println(ret);
    }
}
