package org.wangyt.javase.grammar;

/**
 * return返回的同时也具有断开整个方法的功能,
 * 
 * return必须是同一条件体的最后一句.
 * 
 * @author 王永涛
 * 
 * @date 2012-7-13 下午02:14:49
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,WANGYT. All Rights Reserved.
 */
public class ReturnTest {
	private static int i = (int) ((Math.random()) * 10);

	public static void main(String[] args) {
		System.out.println(i);
		System.out.println(ReturnTest.pri());
	}

	public static String pri() {
		if (i < 5) {
			return "小猫";
		}
		if (i < 10) {
			return "小狗";
		}
		return "小猪";
	}
}