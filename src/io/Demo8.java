package io;
//使用字符流读文件-Reader

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo8 {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("./hello.txt")){
//            while(true){
//                int data = reader.read();
//                if(data == -1){
//                    break;
//                }
//                char c = (char)data;
//                System.out.println(c);
//            }

            char[] chars = new char[1024];
            int n = reader.read(chars);

            for (int i = 0; i < n; i++) {
                System.out.println(chars[i]);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
