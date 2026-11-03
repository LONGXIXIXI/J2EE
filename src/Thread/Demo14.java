package Thread;
//关注NEW,RUNNABLE,TERMINATED状态的转换

public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {

            }
        },"李四");

        System.out.println(thread.getName() + ": " + thread.getState());

        thread.start();

        while (thread.isAlive()){
            System.out.println(thread.getName() + ": " + thread.getState());
        }

        System.out.println(thread.getName() + ": " + thread.getState());
    }
}
