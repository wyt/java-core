package org.wangyt.javase.io.transitionstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * OutputStreamWriter 的构造方法可以将字节输出流对象转换成字符输出流对象，
 * 
 * 该类实例的write方法有将字符编码为字节的作用。
 * 
 * @author 王永涛
 * 
 * @date 2012-7-4 下午05:41:41
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class OutputStreamWriterTest
{
    public static void main(String[] args) throws IOException
    {
        InputStream is = null;
        InputStreamReader isr = null;
        OutputStream os = null;
        OutputStreamWriter osw = null;
        try
        {
            is = new FileInputStream("io/org/xiaotao/javase/io/stream/hanwen.txt");
            isr = new InputStreamReader(is, "EUC-KR");
            os = new FileOutputStream("io/org/xiaotao/javase/io/stream/hanwen_copy.txt");
            // 如果不指定osw的字符集,则使用平台(jvm)默认的字符集。
            osw = new OutputStreamWriter(os, "EUC-KR");

            char[] buffer = new char[1024];
            int readLength = 0;
            while ((readLength = isr.read(buffer)) > 0)
            {
                // osw.write 该方法将buffer中的字符用创建osw对象时指定的字符编码编码为字节写入流中。
                osw.write(buffer, 0, readLength);
            }
            osw.flush();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (is != null)
                is.close();
            if (isr != null)
                isr.close();
            if (os != null)
                os.close();
            if (osw != null)
                osw.close();
        }
    }
}