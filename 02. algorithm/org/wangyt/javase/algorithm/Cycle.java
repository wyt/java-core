package org.wangyt.javase.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 出圈算法，具体如：
 * 
 * "数3退1"(50个人围成一圈数到3和3的倍数时出圈，闻剩下的人是谁，在原来的位置是多少。)
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午02:13:35
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class Cycle
{
    public static int $cycle(int total, int k)
    {
        List<Integer> dataList = new LinkedList<Integer>();
        for (int i = 0; i < total; i++)
            dataList.add(new Integer(i + 1));

        // 第一个应该删除的元素下标
        int index = 2;
        dataList.remove(index);
        // 得到删除的元素之前的元素的下标
        index--;
        while (dataList.size() > 1)
        {
            // 得到应该出局的下标
            index = (index + k) % dataList.size();
            // 移除元素后再得到移除的元素之前的元素的下标(先使用index,然后index自身在减1)
            dataList.remove(index--);
        }
        return ((Integer) dataList.get(0).intValue());
    }

    public static void main(String[] args)
    {
        System.out.println($cycle(50, 3));
    }
}