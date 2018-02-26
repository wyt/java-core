package org.wangyt.javase.algorithm;

/**
 * 电梯
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午01:13:22
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class Elevator
{
    public static void main(String[] args)
    {
        int num = (int) (Math.random() * 10 + 1);// 产生1-10的随机数
        if (num > 5)
        {
            System.out.println("坐电梯");
        } else
        {
            System.out.println("糟糕，爬楼梯");
            // outer 为该循环的标记，可以使用break跳出该层循环
            outer: for (int i = 17; i > 0; i--)
            {
                // i表示楼层
                inter: for (int j = 15; j > 0; j--)
                {
                    // j表示两层之间的台阶数
                    if (j == 15 && j == 1)
                    {
                        System.out.println("电梯开了，坐电梯啦");
                        break outer;
                    }
                    if (j == 8)
                    {
                        System.out.println("我到了第" + i + "层的拐角处");
                    } else if (j == 1)
                    {
                        System.out.println("我到了第" + i + "层");
                    } else
                    {
                        System.out.println("我到了第" + i + "层的第" + j + "台阶了");
                    }
                }
            }
        }
    }
}