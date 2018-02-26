package org.wangyt.javase.io.stream;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author 王永涛
 * 
 * @date 2012-7-4 下午04:01:01
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
@SuppressWarnings("all")
public class FileWriterTest
{
    public static void main(String[] args) throws Exception
    {
        FileReader fr = new FileReader("io/org/xiaotao/javase/io/stream/hanwen.txt");
        FileWriter fw = new FileWriter("io/org/xiaotao/javase/io/stream/hanwen_copy.txt");

        char[] cbuf = new char[1024];
        int len = 0;
        while ((len = fr.read(cbuf)) > 0)
        {
            fw.write(cbuf, 0, len);
        }
        fw.close();
    }
   
}