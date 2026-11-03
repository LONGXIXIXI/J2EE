package Thread;
//线程的状态时一个枚举类型Thread.State

//NEW: 安排了工作，还未开始行动
//RUNNABLE： 可工作的，又可以分成正在工作和即将开始工作
//BLOCKED，WAITING,TIMED_WAITING: 这几个都表示排队等着其他事情
//TERMINATED: 工作完成了

public class Demo13 {
    public static void main(String[] args) {
        for(Thread.State state : Thread.State.values()){
            System.out.println(state);
        }
    }
}
