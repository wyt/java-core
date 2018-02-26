package org.wangyt.javase.io.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 注意：改变console encoding 的编码，jvm character 也会相应的变化。
 * 
 * @author 王永涛
 * 
 * @date 2012-5-15 下午10:14:32
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class FileInputStreamTest
{
    public static void main(String[] args) throws IOException
    {
        // 字节流对象操作的是单个字节
        //FileInputStream fis = new FileInputStream("io/org/xiaotao/javase/io/stream/storeUTF-8.properties");
        FileInputStream fis = new FileInputStream("io/org/xiaotao/javase/io/stream/hanwen.txt");

        // 创建一个缓冲区(缓存)bbuf. byte类型只能存储一个8位(bit),即1个字节(Byte)的数据,所以1024长度的byte数组能存储1024B=1KB的数据。
        byte[] bbuf = new byte[1024];
        int hasRead = 0;

        /*
         * read(byte[] b)内部实现原理：
         * 
         * 其实是read方法内部是由指针控制,每次指针停止时返回实际读取的字节数,造成指针停止
         * 
         * 有两种情况:1.每次读取字节的个数正好是字节数组的长度。 2.刚好读到文件末尾标记之前。
         * 
         * 下一次再从指针停止的地方继续读,如果读到文件末尾标记,返回-1
         */
        while ((hasRead = fis.read(bbuf)) > 0)
        {
            for (int i = 0; i < hasRead; i++)
            {
                System.out.print(bbuf[i] + " ");
            }
            System.out.println();
            
            System.out.println("JRE: " + System.getProperty("java.version")); 
            System.out.println("JVM Character: " + Charset.defaultCharset());
            
            /*
             * storeUTF-8.properties文件是用UTF-8编码的,所以fis.read(bbuf)读到的是UTF-8码表中的值,
             * 
             * 因此我们在将这些字节数解码时要指定编码所用的码表。
             * 
             * 另外如果read()方法读到的字符码值不完整,解码时也会造成乱码。
             * 
             * 注意storeGBK.properties 和 storeUTF-8.properties中存储同样的内容，
             * 
             * 但由于编码不同，一个大小19B，一个大小26B。
             */
            System.out.println(new String(bbuf, 0, hasRead, "EUC-KR"));
            System.out.println(new String(bbuf, 0, hasRead, "GBK"));
        }
        fis.close();
    }
}