package org.wangyt.javase.algorithm;

/**
 * 九九乘法表
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午12:38:00
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class MultiplicationTable
{
    public static void main(String[] args)
    {
        for (int i = 1; i <= 9; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                // System.out.print(i+"*"+j+"="+i*j+"\t");
                System.out.print(j + "*" + i + "=" + i * j + "\t");
                if (i == j)
                {
                    System.out.println();
                }
            }
        }
    }
}