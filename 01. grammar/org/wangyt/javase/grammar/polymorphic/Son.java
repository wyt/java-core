package org.wangyt.javase.grammar.polymorphic;

/**
 * @author wangyt
 * 
 * @date 2015-7-7 上午10:26:55
 * 
 * @version $Rev$
 * 
 * @URL $URL$
 * 
 * @Copyright (c) Copyright 2015 WANGYT, All rights reserved.
 * 
 */
public class Son extends Father {
	public Son() {
	}

	/**
	 * 覆盖父类的方法，因为每个人的兴趣不同
	 */
	@Override
	public String getInterest() {
		System.out.println(this.getClass() + "," + super.getClass());
		System.out.println(this.getMyName() + "," + super.getMyName());
		return getMyName() + "喜欢打游戏.";
	}
}
