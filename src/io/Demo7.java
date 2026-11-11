package io;
//使用字节流写文件-OutputStream
//OutputStream 同样只是⼀个抽象类，要使⽤还需要具体的实现类。我们现在还是只关⼼写⼊⽂件
//中，所以使⽤FileOutputStream

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo7 {
    public static void main(String[] args) {
        //默认情况下，使用OutputStream打开文件，就会“清空文件内容”，可以把追加位设置位true/。
        try (OutputStream outputStream = new FileOutputStream("./hello.txt",true)){
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);

            byte[] bytes = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106};
            //将bytes这个字符数组中从off开始的数据写⼊文件中，⼀共写len个
            outputStream.write(bytes,3,4);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
