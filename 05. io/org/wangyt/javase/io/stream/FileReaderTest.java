package org.wangyt.javase.io.stream;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 字符流对象实质上操作的还是字节，只不过在于一次操作字节的个数的不同：
 * 
 * 由具体的字符集决定,GBK一次操作两个字节,UTF-8根据头信息确定读取几个字节。
 * 
 * FileReader读取文件首先判断当前jvm的平台字符集，然后通过该字符集的特定信息
 * 
 * 判断读取一个字符的时候包含几个字节。
 * 
 * @author 王永涛
 * 
 * @date 2012-7-3 下午03:11:59
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
@SuppressWarnings("all")
public class FileReaderTest
{
    public static void main(String[] args) throws IOException
    {
        //FileReader reader = new FileReader("io/org/xiaotao/javase/io/stream/storeGBK.propertis");
        FileReader reader = new FileReader("io/org/xiaotao/javase/io/stream/hanwen.txt");
        int size;
        
        // 数据在内存(bufferChar)中只能以二进制形式存储。
        char[] bufferChar = new char[64];
        while ((size = reader.read(bufferChar)) > 0)
        {
            System.out.println(new String(bufferChar, 0, size));
        }
        System.out.println("JRE: " + System.getProperty("java.version")); 
        
        /**
         * 如果要避免乱码出现，需要在该类上右键-> run as...-> run configurations... -> common -> 配置编码为 EUC-KR
         */
        System.out.println("JVM Character: " + Charset.defaultCharset());
    }
}