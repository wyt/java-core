package org.wangyt.javase.algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获得任意时间的下一天的时间。
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午01:53:31
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class NextDay
{
    public static void main(String[] args)
    {
        Date now = new Date();
        System.out.println(formatDate(getNextDate(now)));
    }

    /**
     * 根据当前日期得到下一天的日期
     * 
     * @param d
     * @return
     */
    public static Date getNextDate(Date d)
    {
        // 一天的毫秒值。
        long dayTime = 1 * 24 * 60 * 60 * 1000;

        // 用毫秒数构造新的日期
        Date date = new Date(d.getTime() + dayTime);
        return date;
    }
    
    /**
     * 得到固定字符串格式的方法
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date)
    {
        // 年、月、日、 时、分、秒、毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
        String str = sdf.format(date);
        return str;
    }
}