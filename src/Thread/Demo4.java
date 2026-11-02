package Thread;

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        //使用lambda表达式创建Runaable子类对象
        Thread thread = new Thread(() -> {
           while(true){
               System.out.println("hello thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        thread.start();

        while(true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
