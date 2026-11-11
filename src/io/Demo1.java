package io;
//观察get系列的特点和差异
import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("./hello.txt");

        //获取到当前文件所在的目录
        System.out.println(file.getParent());
        //获取到文件的文件名
        System.out.println(file.getName());
        //获取到文件的文件路径
        System.out.println(file.getPath());
        //获取到文件的绝对路径
        System.out.println(file.getAbsolutePath());
        //获取文件整理后的绝对路径
        System.out.println(file.getCanonicalPath());



    }
}
