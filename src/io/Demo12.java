package io;
//扫描指定⽬录，并找到名称或者内容中包含指定字符的所有普通⽂件（不包含⽬录）

import java.io.*;
import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args) {
        //1.输入要扫描的路径，以及要搜索的关键词
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的文件路径");
        String basePath = scanner.next();
        System.out.println("请输入要搜索的关键词");
        String word = scanner.next();

        //2.对输入的内容进行校验
        File baseFile = new File(basePath);
        if(!baseFile.exists() || !baseFile.isDirectory()){
            System.out.println("输入的文件路径错误");
            return;
        }

        if(word.isEmpty()){
            System.out.println("输入的关键词不能为空");
            return;
        }

        //3.递归的进行搜索
        scanDir(baseFile,word);
    }


    private static void scanDir(File file , String word){
        File[] files = file.listFiles();
        if(files == null || files.length == 0  ){
            return;
        }

        for(File f : files){
            System.out.println("当前搜索到文件" + f.getAbsolutePath());
            if(f.isFile()){
                dealFile(f,word);
            }else if(f.isDirectory()){
                scanDir(f,word);
            }
        }
    }

    private static void dealFile(File f, String word){
        if(f.getName().contains(word)){
            System.out.println("找到文件名匹配的结果" + f.getAbsolutePath());
            return;
        }

        StringBuilder content = new StringBuilder();
        try (Reader reader = new FileReader(f)){
            while(true){
                char[] chars = new char[1024];
                int n = reader.read(chars);
                if(n == -1){
                    break;
                }

                content.append(chars,0,n);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        if(content.indexOf(word) != -1){
            System.out.println("找到文件内容匹配的结果" + f.getAbsolutePath());
        }
    }


}
