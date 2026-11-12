package io;
//进⾏普通⽂件的复制

import java.io.*;
import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) throws IOException {
        //1.先让用户输入要复制的源文件路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要复制的源文件路径");
        String srcPath = scanner.next();
        System.out.println("请输入要复制的目标文件路径");
        String destPath = scanner.next();

        //2.对这两个路径做判定
        File srcFile = new File(srcPath);
        if(!srcFile.exists() || !srcFile.isFile()){
            System.out.println("源文件不存在");
            return;
        }

        File destFile = new File(destPath);
        File destParentFile = destFile.getParentFile();
        if(!destParentFile.exists() || !destParentFile.isDirectory()){
            System.out.println("目标文件所在的目录不存在");
            return;
        }

        if(!destFile.exists()){
            destFile.createNewFile();
        }

        //3.进行正真的拷贝操作
        try (InputStream inputStream = new FileInputStream(srcFile) ;
             OutputStream outputStream = new FileOutputStream(destFile)){
           while(true){
               byte[] bytes = new byte[1024];
               int n = inputStream.read(bytes);
               if(n == -1){
                   break;
               }

               outputStream.write(bytes,0,n);
           }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
