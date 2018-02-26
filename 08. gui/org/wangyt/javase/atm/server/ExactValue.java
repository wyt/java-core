package org.wangyt.javase.atm.server;

import java.math.*;

/**
 * 
 * @author 王永涛
 * 
 * @date 2010-12-7
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
class ExactValue
{
    // 精确加法
    public static double add(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1)); // 构建变量v1
        BigDecimal b2 = new BigDecimal(Double.toString(v2)); // 构建变量v2

        return b1.add(b2).doubleValue(); // 返回计算好以后的值
    }

    // 精确除法
    public static double divide(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.divide(b2, 2).doubleValue();
    }

    // 精确乘法
    public static double multiply(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.multiply(b2).doubleValue();
    }

    // 精确减法
    public static double subtract(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.subtract(b2).doubleValue();
    }
}
// ExactValue.subtract()