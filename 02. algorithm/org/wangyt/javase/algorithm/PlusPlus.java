package org.wangyt.javase.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王永涛
 * 
 * @date 2012-9-10 下午03:34:58
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class PlusPlus
{
    public static void main(String[] args)
    {
        List al = new ArrayList();
        for (int i = 0; i < 5; i++)
        {
            al.add(new Integer(i));
        }
        int index = 1;
        al.remove(index--);     // 先使用，后操作。
        // al.remove(--index);  //先操作(自身减减)，后使用
        for (int i = 0; i < al.size(); i++)
        {
            System.out.println(al.get(i));
        }
        System.out.println("index=" + index);
    }
}