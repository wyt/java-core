package org.wangyt.javase.grammar.polymorphic;

/**
 * @author 王永涛
 * 
 * @date 2012-7-8 下午01:59:01
 * 
 * @version v1.0
 * 
 * @Copyright (c) Copyright 2015 WANGYT, All rights reserved.
 * 
 */
public class MainTest {
	public static void main(String[] args) {
		// 在编译的时候用Father做检查，运行时对象还是Son类型
		Father son01 = new Son();
		// Son son01 = new Son();
		son01.setFamilyName("王");
		son01.setFirstName("永涛");

		// 传入对象不同，调用的方法不同
		dynamicInvoke(son01);

		Father father01 = new Father();
		father01.setFamilyName("王");
		father01.setFirstName("启法");

		dynamicInvoke(father01);
	}

	/**
	 * 多态最明显的好处是：可以实现方法的动态调用
	 * 
	 * @param obj
	 */
	private static void dynamicInvoke(Father obj) {
		System.out.println(obj.getInterest());
	}
}
