package org.wangyt.javase.socket.app.spider;

/**
 * @author wangyongtao(sdwyt@foxmail.com)
 * 
 * @date 2014-3-5 下午4:59:26
 * 
 * @version $Rev$
 * 
 * @id $Id${date}
 * 
 * @URL $URL$
 * 
 * @Copyright (c) Copyright 2014 yongtao.wang, All rights reserved.
 */

public class Computing
{
    public static void main(String[] args)
    {
        int a = 823;
        int b = 1000;

        float c = (float) a / b;    // 不同于 float c = (float) a / b;结果
        System.out.println("c: " + c);
    }
}
