package Thread;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {

        //1.使用匿名内部类创建Thread子类对象
        Thread thread1 = new Thread(){
          public void run(){
              while(true){
                  System.out.println("hello thread1");
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
              }
          }
        };


        //2.使用匿名内部类创建Runnable子类对象
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("hello thread2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        while(true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
