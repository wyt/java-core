package org.wangyt.javase.grammar.logicaloperators;

/**
 * @author 王永涛
 * 
 * @date 2012-7-13 下午02:34:02
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class LogicOperatorsTest2
{
    public static void main(String[] args)
    {
        int x = 5;
        boolean b1 = false;

        // "||"为短路或逻辑运算符,当条件中x==5成立的时候，整个表达式的值已经确定，后面表达式不再执行，也就是发生短路。
        if ((x == 5) || (b1 = true))
            System.out.println(b1);

        // "|"逻辑或运算符，整个表达式的值都是需要确定的。
        if ((x == 5) | (b1 = true))
            System.out.println(b1);

        if ((x == 4) && (b1 = true))
            System.out.println("你好");

        System.out.println(b1);

        if ((x == 4) & (b1 = true))
            System.out.println("你好");

        System.out.println(b1);

        int[] x1 = { 1, 2, 3, 4, 5 };
        int[] y = x1;
        System.out.println(y[2]);
        String str = "Hello";
        System.out.println(str == "Hello");
    }
}