package org.wangyt.javase.algorithm;

/**
 * 判断素数(质数，只能被1和自身整除的整数)
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午01:26:02
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class Prime
{
    public static void main(String[] args)
    {
        for (int i = 1; i <= 20; i++)
        {
            if (isPrime(i))
            {
                System.out.println(i);
            }
        }
    }
    /**
     * 判断一个整数是不是素数的方法。
     */
    private static boolean isPrime(int num)
    {
        if (num == 1)
            return false;

        // 从2开始到该数的2次根之间遍历
        long sprtNum = (long) Math.sqrt(num);
        for (int i = 2; i <= sprtNum; i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}