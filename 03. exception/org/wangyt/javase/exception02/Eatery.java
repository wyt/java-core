package org.wangyt.javase.exception02;

/**
 * 定义一个食堂类
 * 
 * @author 王永涛
 * 
 * @date 2012-7-8 下午02:32:13
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class Eatery
{
    private int food;

    public Eatery(int food)
    {
        super();
        this.food = food;
    }

    public int getFood()
    {
        return food;
    }

    public void setFood(int food)
    {
        this.food = food;
    }
}