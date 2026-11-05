package Thread;
//单例模式
//单例模式能保证某个类在程序中只存在唯一一份实例，而不会创建出多个实例
//单例模式具体的实现方式有很多，最常见的是”饿汉“和”懒汉“两种

//饿汉模式
//类加载的同时，创建实例
class Singleton{
    //借助static作用
    //此时通过这样的方式，把实例创建出来
    private static Singleton instance = new Singleton();
    //static修饰方法/属性，此时这样的方法/属性是”类方法/类属性“，不带static称为”实例方法/实例属性“
    //由于instance属性是static，这里初始化操作只会在该类被加载的时候，被初始化一次

    public static Singleton getInstance(){
        return  instance;
    }

    //还需要防止程序员通过其他途径创建出多个实例
    //核心操作，就是把类的构造方法，设为private
    private Singleton(){}

}

//懒汉模式
//类在加载的时候不创建实例，第一次使用的时候才创建实例
class SingletonLazy{
    private  static SingletonLazy instance = null;

    public static SingletonLazy getInstance(){
        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }

    private SingletonLazy(){}
}

//在上面两种单例模式中，饿汉是线程安全的，而懒汉不是线程安全的
//懒汉模式-多线程改进版
class SingletonLazy2{
    private static volatile SingletonLazy2 instance = null;
    //加上volatile是为了防止编译器优化带来的指令重排序，这会引起线程安全的问题
    //指令重排序也是编译器优化的一种手段，按照更优化的顺序来调整执行，保持逻辑不变的前提下，提高效率

    private SingletonLazy2(){}

    public static SingletonLazy2 getInstance(){
        if(instance == null){
            synchronized (SingletonLazy2.class){
                if(instance == null){
                    instance = new SingletonLazy2();
                    //这里可能会触发指令重排序
                }
            }
        }
        return instance;
    }
}

public class Demo26 {
    public static void main(String[] args) {
        //Singleton singleton = new Singleton();
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}
