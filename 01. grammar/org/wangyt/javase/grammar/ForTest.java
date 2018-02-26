package org.wangyt.javase.grammar;

/**
 * @author 王永涛
 * 
 * @date 2012-7-13 下午01:59:07
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,WANGYT. All Rights Reserved.
 */
public class ForTest {
	public static void main(String[] args) {
		int[] intArr = new int[10];
		int flag = 0;

		for (int i = 0; i < intArr.length;) {
			flag = (int) (10000 * Math.random());
			if (flag >= 1000 && flag < 10000) // 如果不满足条件，for循环继续从原值开始。
			{
				intArr[i] = flag;
				i++;
				System.out.print(intArr[i - 1] + " ");
			}
		}
	}
}