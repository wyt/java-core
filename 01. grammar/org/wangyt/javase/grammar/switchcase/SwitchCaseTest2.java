package org.wangyt.javase.grammar.switchcase;

import java.util.Scanner;

/**
 * switch...case... 语句中 break 的用法。
 * 
 * @author 王永涛
 * 
 * @date 2012-7-13 下午02:22:09
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
@SuppressWarnings("all")
public class SwitchCaseTest2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要判断的月份：");
        int num = sc.nextInt();
        while (true)
        {
            showSeason(num);
            System.out.println("请输入您要判断的月份：");
            num = sc.nextInt();
        }
    }

    public static void showSeason(int month)
    {
        switch (month)
        {
	        case 1:
	        case 2:
	        case 3:
	            System.out.println("春季");
	            break;
	        case 4:
	        case 5:
	        case 6:
	            System.out.println("夏季");
	            break;
	        case 7:
	        case 8:
	        case 9:
	            System.out.println("秋季");
	            break;
	        case 10:
	        case 11:
	        case 12:
	            System.out.println("冬季");
	            break;
	        default:
	            System.out.println("您是火星人吧!");
        }
    }
}