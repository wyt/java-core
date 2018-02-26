package org.wangyt.javase.exception02;

/**
 * 自定义一个编译时被检查异常(checked exceptioin)
 * 
 * checked异常对象如果在方法中产生的话,要么捕获处理(try...catch);要么在方法上声明,交给该方法的调用者处理。
 * 
 * @author 王永涛
 * 
 * @date 2012-7-8 下午02:34:25
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class NoFoodCheckedException extends Exception
{
    private static final long serialVersionUID = 8773204234629278180L;

    public NoFoodCheckedException(String msg)
    {
        super(msg);
    }
}