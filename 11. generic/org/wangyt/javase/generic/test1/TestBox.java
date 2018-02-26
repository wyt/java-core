package org.wangyt.javase.generic.test1;

import org.junit.Test;

public class TestBox {

	@Test
	public void testBox() {
		Box<Integer> box = new Box<Integer>();
		box.add(new Integer(10));
		Integer someInteger = box.getT();
		System.out.println(someInteger);
	}

}