package io;
//使用字节流InputStream进行读文件
//InputStream只是一个抽象类，要使用还需要具体的实现类关于InputStream的实现类有很多，基
//本可以认为不同的输⼊设备都可以对应⼀个InputStream类，我们现在只关⼼从⽂件中读取，所以使
//⽤FileInputStream.

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo6 {
    public static void main(String[] args) {

//        //通过read方法读取数据
//        try (InputStream inputStream = new FileInputStream("./hello.txt")){
//            while(true){
//                int data = inputStream.read();
//                if(data == -1){
//                    break;
//                }
//
//                System.out.printf("0x%X\n",data);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        //通过read读取数据，一次读一个字节数组
        try (InputStream inputStream = new FileInputStream("./hello.txt")){
            byte[] bytes = new byte[1024];
            //read方法会尽可能的把参数的数组填满，返回值表示实际读取到的字节数
            int n = inputStream.read(bytes);

            for (int i = 0; i < n; i++) {
                System.out.printf("0x%X\n",bytes[i]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
