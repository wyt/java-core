package org.wangyt.javase.io.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wangyongtao(sdwyt@foxmail.com)
 * 
 * @date 2013-7-25 下午4:25:00
 * 
 * @version $Rev$
 * 
 * @id $Id${date}
 * 
 * @URL $URL$
 * 
 * @Copyright (c) Copyright 2013 yongtao.wang, All rights reserved.
 */
@SuppressWarnings("all")
public class WordUtil
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("io/org/xiaotao/javase/io/stream/wdscb.txt"));
        String line = null;
        while ((line = br.readLine()) != null)
        {
            if ("+".equals(line.charAt(0) + ""))
            {
                System.out.println(line.substring(1).trim());
            }
        }
    }
}