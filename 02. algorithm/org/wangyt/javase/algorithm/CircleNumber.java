package org.wangyt.javase.algorithm;

/**
 * 回文数(类似12321这样的，反着、正着都想同的数。)
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午01:45:02
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class CircleNumber
{
    public static void main(String[] args)
    {
        for (int i = 10; i < 10000; i++)
        {
            if (isCircleNumber(i))
            {
                System.out.println(i);
            }
        }
    }

    private static boolean isCircleNumber(int num)
    {
        int oldValue = num; //保存原始值。
        int temp = 0;   //保存反过之后的值。

        while (num > 0)
        {
            temp = temp * 10 + num % 10;
            num /= 10;
        }

        return temp == oldValue;
    }
}