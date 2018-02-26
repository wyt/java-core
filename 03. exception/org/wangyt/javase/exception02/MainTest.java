package org.wangyt.javase.exception02;

import org.junit.Test;

/**
 * @author 王永涛
 * 
 * @date 2012-7-8 下午02:47:22
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class MainTest
{
    /**
     * 正常情况
     */
    @Test
    public void testStudent()
    {
        Eatery eatery = new Eatery(1);
        Student stu = new Student(10);
        try
        {
            stu.buyFood(7, eatery);
        } catch (NoFoodCheckedException e)
        {
            System.out.println(e);
        }
    }

    /**
     * 出现编译时被检查异常的情况(junit单元测试只检查出现运行时异常的情况)
     */
    @Test
    public void testStudent1()
    {
        Eatery eatery = new Eatery(0);
        Student stu = new Student(10);

        try
        {
            stu.buyFood(7, eatery);
        } catch (NoFoodCheckedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 出现运行时异常的情况
     */
    @Test
    public void testStudent2()
    {
        Eatery eatery = new Eatery(1);
        Student stu = new Student(10);
        try
        {
            stu.buyFood(12, eatery);
        } catch (NoFoodCheckedException e)
        {
            System.out.println(e);
        }
    }
}