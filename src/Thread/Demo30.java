package Thread;
//工厂设计模式
//这个类就是一个工厂类
//这个类就提供了工厂方法，通过工厂方法来创建线程

//表示平面上一个点
//class Point{
//    //通过横纵坐标来构造点
//    public Point(double x , double y){
//        //....
//    }
//
//    //通过极坐标来构造点
//    public Point(double r , double a){
//
//    }
//}

//工厂类
//class Point{
//    //工厂方法
//    public static Point buildPointByXY(double x, double y){
//        Point p = new Point();
//        p.setX(x);
//        p.setY(y);
//        return p;
//    }
//
//    public static Point buildPointByRA(double r, double a){
//        Point p = new Point();
//        p.setR(r);
//        p.setA(a);
//        return p;
//    }
//
//
//}

//工厂设计模式，不适用构造方法进行初始化对象，而是使用专门的“工厂方法”来进行构造。
//工厂方法，就是普通的方法，没有重载限制

//实际使用，需要实现ThreadFactory这个接口，自己实现创建线程对象的操作
//通过线程工厂，创建线程池内部的线程，把创建线程的操作，通过工厂封装提供给用户，就是为了让用户指定一些自定义的逻辑

public class Demo30 {
    public static void main(String[] args) {
        //Point p1 = Point.buildPointByXY(1, 2);
        //Point p2 = Point.buildPointByRA(1, 2);
    }
}
