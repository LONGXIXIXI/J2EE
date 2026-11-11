package io;

import java.io.File;
import java.io.IOException;

//普通文件的创建
public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("./hello.txt");

        System.out.println(file.exists());
        //判定该文件是否是普通文件，如果文件不存在，返回false
        System.out.println(file.isFile());
        //判定该文件是否是目录，如果目录不存在，返回false
        System.out.println(file.isDirectory());

        //根据File对象，自动创建一个空文件，创建成功后返回true
        file.createNewFile();
        System.out.println("文件创建之后");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
