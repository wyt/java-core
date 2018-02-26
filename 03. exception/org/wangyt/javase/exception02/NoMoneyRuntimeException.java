package org.wangyt.javase.exception02;

/**
 * @author 王永涛
 * 
 * @date 2012-7-8 下午02:34:39
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
public class NoMoneyRuntimeException extends RuntimeException
{
    private static final long serialVersionUID = -2161861795128260673L;

    public NoMoneyRuntimeException(String msg)
    {
        super(msg);
    }
}