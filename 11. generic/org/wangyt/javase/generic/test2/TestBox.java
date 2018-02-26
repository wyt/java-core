package org.wangyt.javase.generic.test2;

import org.junit.Test;

public class TestBox {
	
	@Test
	public void testBox() {
		Box<Integer> integerBox = new Box<Integer>();

		integerBox.add(new Integer(10));

		// 为inspect传入 String类型的方法
		integerBox.inspect("some text");
		// 为inspect传入 Integer类型的方法
		integerBox.inspect(new Integer(100));
	}

}