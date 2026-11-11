package io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//普通文件的删除
public class Demo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("./hello.txt");

        if (!file.exists()){
            file.createNewFile();
        }

        //对文件进行删除，删除成功，返回true，删除失败(文件本来就不存在)，返回false
        System.out.println(file.delete());

        file.createNewFile();

        //不是立即删除，而是等待当前进程结束，再触发删除
        file.deleteOnExit();


        //此时去查看文件内容，发现hello.txt任然存在，只用程序运行结束后才会删除
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入任意内容");
        scanner.next();


    }
}
