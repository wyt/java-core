package org.wangyt.javase.generic.test4;

import org.junit.Test;

public class TestBox {
	
	@Test
	public void testBox() {
		
		Box<Integer> integerBox = new Box<Integer>();

		integerBox.add(new Integer(10));

		// must String Type only.
		integerBox.inspect("no errors");
	}
}