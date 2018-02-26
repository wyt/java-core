package org.wangyt.javase.algorithm;

/**
 * 对角线图形
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午01:16:51
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class Catercorner
{
    public static void main(String[] args)
    {
        for (int i = 1; i < 11; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print("0");
            }
            for (int m = 11; m > i; m--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}