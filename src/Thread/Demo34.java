package Thread;
//实现定时器
//定时器的构成
//·一个优先级队列(不要使用 PriorityBlockingQueue，容易死锁)
//·队列中的每个元素都是一个Task对象
//·Task中带有一个时间属性，队首元素就是即将要执行的任务
//·同时有一个Worker线程一直扫描队首元素，看队首元素是否需要执行

import java.util.PriorityQueue;

class MyTimerTask implements Comparable<MyTimerTask>{
    private Runnable runnable;
    //存毫秒级别的时间戳
    private long time;

    public MyTimerTask(Runnable runnable , long delay){
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public long getTime() {
        return time;
    }

    public void run(){
        runnable.run();
    }

    @Override
    public int compareTo(MyTimerTask o) {
        //时间小的在队首(小堆)
        return (int)(this.time - o.time);
    }
}

class MyTimer{
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    private Object locker = new Object();

    public MyTimer(){
        //创建专门的线程，负责执行队列中的任务
        Thread thread = new Thread(() -> {
            //从队列中取队首元素
            //判定队首元素是否时间到了
            //时间没到，先不执行
            //时间到了，执行任务，并把元素出队列
           try {
               while(true){
                   synchronized (locker){
                       while(queue.isEmpty()){
                           locker.wait();
                       }
                       MyTimerTask task = queue.peek();
                       if(task.getTime() <= System.currentTimeMillis() ){
                           //时间到了，可以执行任务了
                           task.run();
                           queue.poll();
                       }else{
                           //需要带有超时间的等待
                           locker.wait(task.getTime() - System.currentTimeMillis());
                       }
                   }
               }
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        });
        thread.start();
    }

    public void schedule(Runnable task,long delay){
        synchronized (locker){
            queue.offer(new MyTimerTask(task,delay));
            locker.notify();
        }
    }
}

public class Demo34 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1");
            }
        },4000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2");
            }
        },3000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3");
            }
        },2000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 4");
            }
        },1000);
    }
}
