package org.wangyt.javase.grammar;

/**
 * @author 王永涛
 * 
 * @date 2012-7-13 下午01:51:17
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,WANGYT. All Rights Reserved.
 * 
 */
public class BreakTest {
	public static void main(String[] args) {
		int temp = 4;
		for (int i = 0; i < 6; i++) {
			if (i == temp) {
				break;
			}
			System.out.println(i);
		}
	}
}