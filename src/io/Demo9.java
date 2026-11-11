package io;
//使用字符流Writer进行读文件

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo9 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("./hello.txt",true)){
            //writer.write('我');

//            char[] chars = {'爱','你','中','国'};
//            writer.write(chars);

            String s = "。";
            writer.write(s);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
