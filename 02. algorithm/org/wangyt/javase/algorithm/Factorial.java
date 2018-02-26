package org.wangyt.javase.algorithm;

import java.util.Scanner;

/**
 * 求阶乘(递归算法)
 * 
 * @author 王永涛
 * 
 * @date 2012-7-8 下午04:09:43
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,WANGYT. All Rights Reserved.
 */
@SuppressWarnings("all")
public class Factorial {
	public static void main(String[] args) {
		System.out.println("请输入一个整数: ");
		Scanner sc = new Scanner(System.in);
		long m = sc.nextInt();
		System.out.println(m + "的阶乘为: \n" + factorial(m));
	}

	public static long factorial(long n) {
		if (n == 1) {
			return 1;
		} else {
			// factorial(n -1) 必须要返回一个结果，所以要用return关键字。
			return (n * factorial(n - 1));
		}
	}
}