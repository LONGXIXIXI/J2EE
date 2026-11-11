package io;
//文件的重命名

import java.io.File;
import java.io.IOException;

public class Demo5 {
    public static void main(String[] args) throws IOException {
//        File fileScr = new File("./test/111.txt");
//        File fileDest = new File("./test/222.txt");
//
//        fileScr.createNewFile();
//
//        //把111.txt重命名成222.txt
//        System.out.println(fileScr.renameTo(fileDest));

        //移动，就是把dest的路径写道其他的目录中即可
        File fileSrc = new File("./test/222.txt");
        File fileDest = new File("./test/111/222.txt");

        System.out.println(fileSrc.renameTo(fileDest));


    }
}
