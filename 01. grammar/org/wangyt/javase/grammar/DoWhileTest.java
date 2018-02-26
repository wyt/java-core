package org.wangyt.javase.grammar;

/**
 * @author 王永涛
 * 
 * @date 2012-7-13 下午01:57:34
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,WANGYT. All Rights Reserved.
 */
public class DoWhileTest {
	public static void main(String[] args) {
		int i = 4;
		while (i < 10) {
			System.out.println(i);
			i++;
		}
		System.out.println("=========================");
		i = 10;
		do {
			System.out.println(i);
			i++;
		} while (i < 10);
	}
}