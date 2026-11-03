package Thread;
//获取当前线程引用

// public static Thread currentThread()     返回当亲线程对象的引用

public class Demo12 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run(){
                //可以使用this获取到当前线程的引用
                //此处继承Thread的方式来创建线程的
                //this指向的就是Thread对象
                System.out.println(this.getName());
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //此处this指向的是Runnable的实例
                //System.out.println(this.getName());
                //只能使用currentThread()
                System.out.println(Thread.currentThread().getName());
            }
        });

        Thread thread2 = new Thread(() -> {
            //lambda中没有this
            //System.out.println(this.getName());
            System.out.println(Thread.currentThread().getName());
        });

        thread.start();
        thread1.start();
        thread2.start();
    }
}
