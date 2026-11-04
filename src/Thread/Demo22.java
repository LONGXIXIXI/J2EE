package Thread;
//Java标准库中的线程安全类

//Java 标准库中很多都是线程不安全的.这些类可能会涉及到多线程修改共享数据,⼜没有任何加锁措
//施.
//ArrayList
//LinkedList
//HashMap
//TreeMap
//HashSet
//TreeSet
//StringBuilder

//但是还有⼀些是线程安全的.使⽤了⼀些锁机制来控制.
//Vector(不推荐使⽤)
//HashTable(不推荐使⽤)
//ConcurrentHashMap
//StringBuffer

import java.util.Vector;

//还有的虽然没有加锁,但是不涉及"修改",仍然是线程安全的
//String
public class Demo22 {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        Thread thread = new Thread(() -> {
            if(v.isEmpty()){
                v.add("hello");
            }
        });

        Thread thread1 = new Thread(() -> {
            if(v.isEmpty()){
                v.add("hello");
            }
        });
    }
}
