package org.wangyt.javase.grammar;

/**
 * for(elementType cite:Collection){}
 * 
 * Collection:表示所要遍历的集合(容器)，此处是一个引用指向该集合。
 * 
 * elementType:表示集合Collection中元素的数据类型，可为基本数据类型，也可抽象数据类型。
 * 
 * cite:tape类型的变量，用于对应集合Collection中的tape类型元素。
 * 
 * @author 王永涛
 * 
 * @date 2012-7-13 下午02:44:58
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,WANGYT. All Rights Reserved.
 */
public class 增强for {
	public static void main(String[] args) {
		int[] intArray = { 12, 11, 45, 23, 31 };

		for (int i : intArray) {
			System.out.println(i);
		}
	}
}