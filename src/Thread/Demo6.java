package Thread;

//       属性             获取方法
//       ID              getId()           ID是线程的唯一标识，不同线程不会重复
//       名称             getName()         名称是各种调试工具用到
//       状态             getState()        状态表示线程当前所处的一个情况
//       优先级           getPriority()     优先级高的线程理论上来说更容易被调度到
//       是否后台线程       isDaemon()       JVM会在一个进程的所有非后台线程结束后，才会结束运行
//       是否存活          isAlive()         简单理解为run方法是否运行结局了
//       是否被中断        isInterrupted()

public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "我还活着");
                try {
                    Thread.sleep(i * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(Thread.currentThread().getName() + "我即将死去");
        });

        System.out.println(Thread.currentThread().getName() + ": ID:" + thread.getId());
        System.out.println(Thread.currentThread().getName() + ": 名称:" + thread.getName());
        System.out.println(Thread.currentThread().getName() + ": 状态:" + thread.getState());
        System.out.println(Thread.currentThread().getName() + ": 优先级:" + thread.getPriority());
        System.out.println(Thread.currentThread().getName() + ": 后台线程:" + thread.isDaemon());
        System.out.println(Thread.currentThread().getName() + ": 活着:" + thread.isAlive());
        System.out.println(Thread.currentThread().getName() + ": 被中断:" + thread.isInterrupted());


        thread.start();

        while(thread.isAlive()){
            System.out.println(Thread.currentThread().getName() + "状态" + thread.getState());
            Thread.sleep(1000);
        }
    }
}
