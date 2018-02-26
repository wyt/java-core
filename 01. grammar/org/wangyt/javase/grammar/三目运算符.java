package org.wangyt.javase.grammar;

/**
 * @author 王永涛
 * 
 * @date 2012-7-13 下午02:40:21
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class 三目运算符
{
    public static void main(String[] args)
    {
        int score = 80;
        int x = -10;
        String type = score < 60 ? "不及格" : "及格";
        int flag = x > 0 ? 1 : (x == 0 ? 0 : -1);
        System.out.println("type=" + type);
        System.out.println("flag=" + flag);
    }
}