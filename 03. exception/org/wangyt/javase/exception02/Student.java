package org.wangyt.javase.exception02;

/**
 * 定义一个学生类。
 * 
 * @author 王永涛
 * 
 * @date 2012-7-8 下午02:33:33
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class Student
{
    private int money;

    public Student()
    {
    }

    public Student(int money)
    {

        this.money = money;
    }

    /**
     * 
     * 方法中如果产生异常对象,若是checked异常,则要么捕获处理,要么在方法上用throws声明 ;若是runtime异常,则不需捕获处理,也不需要在方法上声明。
     * 
     * @param foodFrice
     * @param eatery
     * @throws NoFoodCheckedException
     */
    public void buyFood(int foodFrice, Eatery eatery) throws NoFoodCheckedException
    {
        if (eatery.getFood() <= 0)
        {
            // 产生 编译时被检查异常对象
            throw new NoFoodCheckedException("食堂没饭了！");
        }
        if (this.money < foodFrice)
        {
            // 产生 运行时异常对象
            throw new NoMoneyRuntimeException("哥们没钱了！");
        } else
        {
            System.out.println("交易成功！");
        }
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }
}