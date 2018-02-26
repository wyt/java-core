package org.wangyt.javase.io.character;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author 王永涛
 * 
 * @date 2012-7-5 上午11:30:33
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class TestCharacter
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        /**
         * 无论是程序内部或者外部读入的字符数据，在jvm内存中都会被转换成Unicode编码
         * 
         * 下面的语句在向控制该打印 "汉" 的时候，其过程是这样的：
         * 
         * 首先"汉"在jvm 内存中以Unicode编码方式存储，out为PrintStream流，该输出流
         * 
         * 的输出方法会通过字符集映射表将"汉"的Unicode编码转换为jvm平台默认的编码(例如GBK)，
         * 
         * 然后将转换后的编码打印到控制台，如果控制台编码和jvm平台编码一致，则可以正确的显示出字符数据。
         */
        System.out.println("汉");

        String han = "汉"; // 等同于char han = 0x6c49;
        char[] array = han.toCharArray();
        for (char c : array)
        {
            // 得到该字符Unicode编码的十六进制表示
            System.out.format("%x", (int) c);
            System.out.println();
            System.out.println(Integer.toHexString((int) c));
        }
        String encoding = System.getProperty("file.encoding");
        System.out.println("System encoding: "+encoding);
        System.out.println("Jvm encoding: "+Charset.defaultCharset());
    }
}