package org.wangyt.javase.grammar;

/**
 * @author 王永涛
 * 
 * @date 2012-7-13 下午02:11:40
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,WANGYT. All Rights Reserved.
 */
public class IfTest {
	public static void main(String[] args) {
		int i = 20;
		if (i < 40) {
			System.out.println("<40");
		} else if (i < 30) {
			System.out.println("<30");
		} else if (i > 10) {
			System.out.println(">10");

		} else
			// 不加大括号if只作用于其后面一句。
			System.out.println(">=40");
	}
}
