package Thread;

class MyBlockingQueue{
    private String[] data;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private Object locker = new Object();

    public MyBlockingQueue(int capacity){
        data = new String[capacity];
    }

    public void put(String elem) throws InterruptedException {
        synchronized (locker){
            while(size == data.length){
                locker.wait();
            }
            data[tail] = elem;
            tail++;
            if(tail >= data.length){
                tail = 0;
            }
            size++;
            locker.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (locker){
            while(size == 0){
                locker.wait();
            }
            String ret = data[head];
            head++;
            if(head >= data.length){
                head = 0;
            }
            size--;
            locker.notify();
            return ret;
        }
    }


}
public class Demo29 {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(10);

        Thread producer = new Thread(() -> {
            try {
                int count = 0;
                while(true){
                    queue.put(count+" ");
                    System.out.println("生产元素" + count);
                    count++;
                }
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {

                try {
                    while(true){
                        String ret = queue.take();
                        System.out.println("消费元素" + ret);
                        Thread.sleep(1000);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        });

        producer.start();
        consumer.start();
    }

}
