package org.wangyt.javase.grammar;

/**
 * @author 王永涛
 * 
 * @date 2012-7-13 下午01:55:24
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,WANGYT. All Rights Reserved.
 */
public class ContinueTest {
	public static void main(String[] args) {
		int m = 3;
		for (int i = 0; i < 8; i++) {
			System.out.print(i);
			if (i == m) {
				// 条件为真的时候，会跳过其后的语句，进入下一次循环。
				continue;
			}
			System.out.println("$");
		}
	}
}