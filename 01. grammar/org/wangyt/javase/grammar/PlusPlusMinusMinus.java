package org.wangyt.javase.grammar;

/**
 * i++ 先使用
 * 
 * @author 王永涛
 * 
 * @date 2012-7-13 下午02:29:48
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,WANGYT. All Rights Reserved.
 */
public class PlusPlusMinusMinus {
	public static void main(String[] args) {
		int i1 = 18;
		int i2 = 19;
		int i = i2++;// 先把i2的值赋给i，然后i2自身在加1
		System.out.println("i=" + i);
		System.out.println("i2=" + i2);

		i = --i1;// i1先自身减1，然后再把减1后得到的值赋给i
		System.out.println("i=" + i);
		System.out.println("i1=" + i1);

		i = i1--;
		System.out.println("i=" + i);
		System.out.println("i1=" + i1);

		i = ++i2;
		System.out.println("i=" + i);
		System.out.println("i2=" + i2);
	}
}