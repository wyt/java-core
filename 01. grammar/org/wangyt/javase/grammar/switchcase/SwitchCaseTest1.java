package org.wangyt.javase.grammar.switchcase;

/**
 * switch() 中类型：byte short char int 枚举貌似也可以。。。
 * 
 * @author 王永涛
 * 
 * @date 2012-7-13 下午02:21:59
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class SwitchCaseTest1
{
    public static void main(String[] args)
    {
        char i = '6';
        switch (i)
        {
	        case '6':
	            System.out.println("执行第一个语句！");
	            break;
	        case '3':
	            System.out.println("执行第二个语句！");
	            break;
	        case '4':
	            System.out.println("执行第三个语句！");
	            break;
	        case '2':
	            System.out.println("执行第四个语句！");
	            break;
	        case '1':
	            System.out.println("执行第五个语句！");
	            break;
	        default:
	            System.out.println("错误数据！");
	            break;
        }
    }
}