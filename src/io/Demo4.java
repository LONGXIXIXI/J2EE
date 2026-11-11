package io;

import java.io.File;
import java.util.Arrays;

//目录的创建
public class Demo4 {
    public static void main(String[] args) {
        File dir = new File("test");

        System.out.println(dir.isDirectory());
        System.out.println(dir.isFile());
        System.out.println(dir.mkdir());
        System.out.println(dir.isDirectory());
        System.out.println(dir.isFile());

        File file = new File("./src/io");

        //通过list列出目录下的内容，每个元素，就是当前目录下每个文件/目录的名字
        String[] list = file.list();
        System.out.println(list.length);
        System.out.println(Arrays.toString(list));

        //通过listFile列出目录下的内容，每个元素，就是当前目录下每个文件/目录的File对象
        File[] listFile = file.listFiles();
        System.out.println(Arrays.toString(listFile));



    }
}
