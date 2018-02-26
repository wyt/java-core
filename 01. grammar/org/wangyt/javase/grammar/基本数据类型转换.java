package org.wangyt.javase.grammar;

/**
 * @author wangyt
 * 
 * @date 2015-5-25 下午3:51:08
 * 
 * @version $Rev$
 * 
 * @URL $URL$
 * 
 * @Copyright (c) Copyright 2015 WANGYT, All rights reserved.
 * 
 */
public class 基本数据类型转换 {
	public static void main(String[] args) {
		int num01 = 123;
		int num02 = 456;

		// 系统自动转换成double进行计算
		double num_double = (num01 + num02) * 1.2;

		// 类型转换
		float num_float = (float) ((num01 + num02) * 1.2);

		byte b1 = 67;
		byte b2 = 89;

		// 强制类型转换
		byte num_byte = (byte) (b1 + b2);

		System.out.println(num_double);
		System.out.println(num_float);
		System.out.println(num_byte);

		// 必须加f
		float f3 = 1.23f;
		// 10的200次方
		double d2 = 1e200;
		float f2 = (float) d2;
		System.out.println(f2 + "," + f3);

		// 必须加L或l
		long ll = 88888888L;
		System.out.println(ll);
	}
}