package io;

//扫描指定目录，并找到名称中包含指定字符的所有普通文件(不包含目录)
//并且后续询问用户是否要删除该文件

import java.io.File;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        //1.让用户通过控制台输入路径和指定字符串
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的文件路径:");
        String basePath = scanner.next();
        System.out.println("请输入要搜索的文件名称");
        String word = scanner.next();

        //2.需要对用户的输入进行校验，看一下basePath是否是合法的路径，word是否为空
        File baseFile = new File(basePath);
        if(!baseFile.exists() || !baseFile.isDirectory()){
            System.out.println("输入的路径错误");
            return;
        }

        if(word.isEmpty()){
            System.out.println("输入的文件名称错误");
            return;
        }

        //3.单独创建方法，完成递归查找操作
        scanDir(baseFile,word);
    }

    private static void scanDir(File baseFile , String word){
        //1.列出baseFile下的所有对象，希望直接拿到File对象，(判定文件是普通文件还是目录)
        File[] files = baseFile.listFiles();
        if(files == null || files.length == 0){
            return;
        }

        //2.遍历数组
        for(File f : files){
            System.out.println("当前搜索文件" + f.getAbsolutePath());
            if(f.isFile()){
                dealFile(f,word);
            }else if(f.isDirectory()){
                scanDir(f,word);
            }
        }
    }


    private static void dealFile(File f, String word){
        if(f.getName().contains(word)){
            System.out.println("是否删除" + f.getAbsolutePath() + "(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if(choice.equals("Y") || choice.equals("y")){
                f.delete();
            }else {

            }
        }
    }
}
